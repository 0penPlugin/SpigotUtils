package com.openplugins.utils.command;

import com.openplugins.utils.config.ConfigAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandBlocker implements Listener {

    @EventHandler
    public void playerCommand(PlayerCommandPreprocessEvent playerCommandPreprocessEvent) {
        Player player = playerCommandPreprocessEvent.getPlayer();
        String command = playerCommandPreprocessEvent.getMessage();

        if (command.startsWith("/minecraft:")) {
            if (!ConfigAPI.getBoolean("settings.defaultCommands")) {
                if (!player.hasPermission("openplugins.admin")) {
                    playerCommandPreprocessEvent.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "You do not have permission to execute this command.");
                }
            }
        }
    }
}
