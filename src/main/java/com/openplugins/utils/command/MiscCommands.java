package com.openplugins.utils.command;

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
        }
    }

}
