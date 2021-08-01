package de.zoom.opskyblock;

import de.zoom.opskyblock.commands.TestCommand;
import me.lucko.helper.plugin.ExtendedJavaPlugin;

public class OPSkyblockPlugin extends ExtendedJavaPlugin {
    private static OPSkyblockPlugin instance;

    @Override
    protected void enable() {
        instance = this;

        registerCommand(new TestCommand()); // It's that simple, no need of plugin.yml
    }

    @Override
    protected void disable() {
        instance = null;
    }

    public static OPSkyblockPlugin getInstance() {
        return instance;
    }
}
