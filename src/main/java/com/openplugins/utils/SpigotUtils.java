package com.openplugins.utils;

import com.openplugins.utils.config.ConfigAPI;
import com.openplugins.utils.web.Request;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotUtils extends JavaPlugin {

    private String version;
    private Request verRequest;
    private boolean defaultCommands, spigotCommands, pluginCommand;

    private static SpigotUtils instance;

    @Override
    public void onEnable() {
        instance=this;
        this.version="1.0.0";
        verRequest = new Request("http://openplugins.atspace.cc/","version.php");

        if (verRequest.request("version").equalsIgnoreCase(version)) {
            Bukkit.getLogger().info("Plugin is up to date!");
        } else {
            Bukkit.getLogger().info("Plugin is out of date :(");
        }

        pluginCommand = ConfigAPI.getBoolean("settings.pluginCommand");
        defaultCommands = ConfigAPI.getBoolean("settings.defaultCommands");
        spigotCommands = ConfigAPI.getBoolean("settings.spigotCommands");
    }

    @Override
    public void onDisable() {
    }

    public static SpigotUtils getInstance() {
        return instance;
    }

    public boolean isSpigotCommands() {
        return spigotCommands;
    }

    public boolean isDefaultCommands() {
        return defaultCommands;
    }

    public boolean isPluginCommand() {
        return pluginCommand;
    }
}
