package de.zoom.opskyblock;

import de.zoom.opskyblock.api.data.DataHelper;
import de.zoom.opskyblock.api.data.ModelId;
import de.zoom.opskyblock.api.data.impl.MongoDataHelper;
import de.zoom.opskyblock.commands.TestCommand;
import de.zoom.opskyblock.listeners.PlayerListener;
import lombok.Getter;
import me.lucko.helper.plugin.ExtendedJavaPlugin;
import me.lucko.helper.utils.Log;

@Getter
public class OPSkyblockPlugin extends ExtendedJavaPlugin {
  @Getter
  private static OPSkyblockPlugin instance;

  private DataHelper dataHelper;

  @Override
  protected void enable() {
    instance = this;

    dataHelper = new MongoDataHelper("", "");
    dataHelper.exists(ModelId.empty()); // Runs a test connection to MongoDB.
    Log.info("Connected to MongoDB...");

    registerListeners();
    registerCommands();
    Log.info("Registered commands and event listeners...");

    Log.info("OPSkyblock has successfully started.");
  }

  @Override
  protected void disable() {
    if(dataHelper != null) {
      dataHelper.close();
      Log.info("Disconnected from MongoDB...");
    }

    Log.info("OPSkyblock has successfully stopped.");

    instance = null;
  }

  private void registerCommands() {
    new TestCommand().registerAndBind(this, "test-command"); // It's that simple, no need of plugin.yml
  }

  private void registerListeners() {
    registerListener(new PlayerListener());
  }
}
