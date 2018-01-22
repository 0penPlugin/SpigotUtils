package com.openplugins.utils.config;

import com.openplugins.utils.SpigotUtils;

public class ConfigAPI {

    public static boolean getBoolean(String location) {

        return SpigotUtils.getInstance().getConfig().getBoolean(location);
    }

    public static void toggleBoolean(String location) {

        String result = (getBoolean(location) ? "false" : "true");

        SpigotUtils.getInstance().getConfig().set(location,Boolean.valueOf(result));
    }

}
