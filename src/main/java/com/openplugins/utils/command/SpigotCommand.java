package com.openplugins.utils.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpigotCommand implements CommandExecutor {

    public void sendArgs(Player player, String command) {
        player.sendMessage(ChatColor.GRAY + "/" + command + " <args>");
    }

    public void sendPermission(Player player) {
        player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be player!");
            return true;
        }

        executeCommand(((Player) sender),cmd,args);

        return false;
    }

    public void executeCommand(Player sender, Command cmd, String args[]) {}
}
