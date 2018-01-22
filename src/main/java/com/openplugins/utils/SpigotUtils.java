package com.openplugins.utils;

import com.openplugins.utils.web.Request;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotUtils extends JavaPlugin {

    private String version;
    private Request verRequest;

    @Override
    public void onEnable() {
        this.version="1.0.0";
        verRequest = new Request("http://openplugins.atspace.cc/","version.php");

        if (verRequest.request("version").equalsIgnoreCase(version)) {
            Bukkit.getLogger().info("Plugin is up to date!");
        } else {
            Bukkit.getLogger().info("Plugin is out of date :(");
        }
    }

    @Override
    public void onDisable() {
    }
}
