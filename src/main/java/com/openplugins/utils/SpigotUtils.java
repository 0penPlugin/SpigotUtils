package com.openplugins.utils;

import com.openplugins.utils.command.AdminCommand;
import com.openplugins.utils.command.CommandBlocker;
import com.openplugins.utils.command.MiscCommands;
import com.openplugins.utils.config.ConfigAPI;
import com.openplugins.utils.web.Request;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotUtils extends JavaPlugin {

    private String version;
    private Request verRequest;
    private boolean defaultCommands, spigotCommands, pluginCommand;
    private AdminCommand adminCommand;
    private MiscCommands miscCommands;
    private PluginManager pluginManager;

    private static SpigotUtils instance;

    @Override
    public void onEnable() {
        instance=this;
        this.saveDefaultConfig();
        this.version="1.0.0";
        verRequest = new Request("http://openplugins.atspace.cc/","version.php");

        if (verRequest.request("version").contains(version)) {
            Bukkit.getLogger().info("Plugin is up to date!");
        } else {
            Bukkit.getLogger().info("Plugin is out of date :(");
            Bukkit.getLogger().info(verRequest.request("version"));
        }

        pluginCommand = ConfigAPI.getBoolean("settings.pluginCommand");
        defaultCommands = ConfigAPI.getBoolean("settings.defaultCommands");
        spigotCommands = ConfigAPI.getBoolean("settings.spigotCommands");

        adminCommand = new AdminCommand();
        miscCommands = new MiscCommands();

        getCommand("update").setExecutor(adminCommand);
        getCommand("kick").setExecutor(adminCommand);

        getCommand("tab").setExecutor(miscCommands);
        getCommand("broadcast").setExecutor(miscCommands);

        pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new CommandBlocker(),this);
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

    public String getVersion() {
        return version;
    }
}
