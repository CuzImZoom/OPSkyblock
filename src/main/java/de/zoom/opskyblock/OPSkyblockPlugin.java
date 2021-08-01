package de.zoom.opskyblock;

import me.lucko.helper.maven.MavenLibrary;
import me.lucko.helper.plugin.ExtendedJavaPlugin;

@MavenLibrary(groupId = "org.mongodb", artifactId = "mongo-java-driver", version = "3.12.9")
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
