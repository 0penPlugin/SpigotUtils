package com.openplugins.utils.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class MiscCommands extends SpigotCommand {

    @Override
    public void executeCommand(Player sender, Command cmd, String args[]) {
        if (cmd.getName().equalsIgnoreCase("tab")) {
            if (!sender.hasPermission("spigotutils.tab") || !sender.hasPermission("openplugins.admin")) {
                sendPermission(sender);
                return;
            }

            if (args.length == 0) {
                sendArgs(sender,cmd.getName());
                return;
            }

            sender.setPlayerListName(ChatColor.translateAlternateColorCodes('&',args[0]));
        } else if (cmd.getName().equalsIgnoreCase("broadcast")) {
            if (!sender.hasPermission("spigotutils.broadcast") || !sender.hasPermission("openplugins.admin")) {
                sendPermission(sender);
                return;
            }

            if (args.length == 0) {
                sendArgs(sender,cmd.getName());
                return;
            }

            String message = "";

            for (String s : args) {
                message=message + " " +s;
            }

            sender.sendMessage(ChatColor.GREEN + "Sending broadcast!");
            Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "[Broadcast] " + ChatColor.RESET + ChatColor.translateAlternateColorCodes('&',message));
        } 
    }

}
