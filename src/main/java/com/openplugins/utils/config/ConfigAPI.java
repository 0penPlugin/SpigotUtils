package com.openplugins.utils.config;

import com.openplugins.utils.SpigotUtils;

public class ConfigAPI {

    public static boolean getBoolean(String location) {

        if (SpigotUtils.getInstance().getConfig().getString(location).equalsIgnoreCase("true")) {
            return true;
        }

        return false;
    }

}
