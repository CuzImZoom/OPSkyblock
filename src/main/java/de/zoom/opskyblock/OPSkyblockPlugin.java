package de.zoom.opskyblock;

import me.lucko.helper.plugin.ExtendedJavaPlugin;

public class OPSkyblockPlugin extends ExtendedJavaPlugin { // that class is an abstract class, which is sort of like an interface, except mixed with a class
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
