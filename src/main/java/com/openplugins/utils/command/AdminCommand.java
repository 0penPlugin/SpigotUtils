package com.openplugins.utils.command;

import com.openplugins.utils.SpigotUtils;
import com.openplugins.utils.config.ConfigAPI;
import com.openplugins.utils.web.Request;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommand implements CommandExecutor {

    public void sendArgs(Player player, String command) {
        player.sendMessage(ChatColor.GRAY + "/" + command + " <args>");
    }

    public void sendPermission(Player player) {
        player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Sender must be player!");
            return true;
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("update")) {
            if (!player.hasPermission("spigotutils.admin") || !player.hasPermission("openplugins.admin")) {
                sendPermission(player);
                return true;
            }

            String version = SpigotUtils.getInstance().getVersion();
            Request verRequest = new Request("http://openplugins.atspace.cc/","version.php");

            if (verRequest.request("version").contains(version)) {
                player.sendMessage(ChatColor.GREEN + "SpigotUtils is up to date!");
            } else {
                player.sendMessage(ChatColor.RED + "SpigotUtils is out of date!");
            }
        }

        if (cmd.getName().equalsIgnoreCase("toggleboolean")) {
            if (!player.hasPermission("spigotutils.admin") || !player.hasPermission("openplugins.admin")) {
                sendPermission(player);
                return true;
            }

            if (args.length == 0) {
                sendArgs(player,cmd.getName());
                return true;
            }

            String b = args[0];

            try {
                ConfigAPI.toggleBoolean(b);
            } catch(Exception e) {
                player.sendMessage(ChatColor.RED + "Invalid command usage!");
                e.printStackTrace();
            }
        }

        return false;
    }
}
