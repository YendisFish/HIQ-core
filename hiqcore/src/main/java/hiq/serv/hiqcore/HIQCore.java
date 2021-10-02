package hiq.serv.hiqcore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HIQCore extends JavaPlugin implements Listener{

    //public String AllowedPlayers = this.getConfig().getString("allowed-players");
    //public String[] prmP = AllowedPlayers.split(",");

    @Override
    public void onEnable() {
        System.out.println(ChatColor.GREEN + "HIQ-Core started!");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents((Listener) this, this);

        String[] alparray = allowedplayers().toArray(new String[0]);

        for(int i = 0; i < alparray.length; i++) {
            System.out.println("Allowed Player: " + alparray[i]);
        }
    }

    public List<String> allowedplayers() {
        getConfig().options().copyDefaults();

        String AllowedPlayers = getConfig().getString("allowed-players");
        String[] tolist = AllowedPlayers.split(",");
        List<String> prmP = Arrays.stream(tolist).collect(Collectors.toList());
        return prmP;
    }

    public List<String> blacklistjoinmsgplayers() {
        getConfig().options().copyDefaults();

        String playerstr = getConfig().getString("blacklist-join-msg");
        String[] tolist = playerstr.split(",");
        List<String> playerlist = Arrays.stream(tolist).collect(Collectors.toList());

        return playerlist;
    }

    //commands

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("version")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;

                if(allowedplayers().contains(p.getUniqueId().toString())) {
                    p.sendMessage("HIQ Core Version 1.0 [Alpha]");
                } else {
                    System.out.println("Player doesn't have sufficient permissions");
                }
            }
        }
        if(command.getName().equalsIgnoreCase("evolve")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;

                if(allowedplayers().contains(p.getUniqueId().toString())) {
                    p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "YOU HAVE EVOLVED!");

                    try {
                        Vector dir = p.getLocation().getDirection();
                        p.setVelocity(dir.multiply(Integer.parseInt(args[0])));
                    } catch (Exception ex) {
                        p.sendMessage(ChatColor.RED + "Please type a valid number!");
                    }
                }
            }
        }


        return true;
    }

    //Events that need access to the config

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = (Player) e.getPlayer();

        if(!blacklistjoinmsgplayers().contains(p.getUniqueId().toString())) {
            p.sendMessage(ChatColor.AQUA + "Have you joined our discord server? Join at https://discord.gg/jhwHswMYgz");
        } else  {
            System.out.println(p.getDisplayName() + "is blacklisted for onJoin message!");
        }
    }

}
