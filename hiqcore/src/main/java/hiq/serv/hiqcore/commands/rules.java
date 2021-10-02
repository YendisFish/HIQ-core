package hiq.serv.hiqcore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class rules implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;

            System.out.println("Listing rules to " + p.getDisplayName());

            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Rules");
            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "1." + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "No Bullying other players");
            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "2." + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "No lag machines");
            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "3." + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "No cheats or things that can count as cheats");
            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "4." + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "No slurs");
            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "5." + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "If you dont support LGBTQ get out!");
            p.sendMessage("For more information contact one of the server administrators or go to our discord " + ChatColor.AQUA + "(https://discord.gg/jhwHswMYgz)");
        }

        return true;
    }
}
