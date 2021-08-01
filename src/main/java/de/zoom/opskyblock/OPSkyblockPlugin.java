package de.zoom.opskyblock;

import me.lucko.helper.plugin.ExtendedJavaPlugin;

public class OPSkyblockPlugin extends ExtendedJavaPlugin {
    private static OPSkyblockPlugin instance;

    @Override
    protected void enable() {
        instance = this;
    }

    @Override
    protected void disable() {
        instance = null;
    }

    public static OPSkyblockPlugin getInstance() {
        return instance;
    }
}
