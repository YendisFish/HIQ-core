package hiq.serv.hiqcore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HIQCore extends JavaPlugin {

    //public String AllowedPlayers = this.getConfig().getString("allowed-players");
    //public String[] prmP = AllowedPlayers.split(",");

    @Override
    public void onEnable() {
        System.out.println(ChatColor.GREEN + "HIQ-Core started!");

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

        return true;
    }


}
