package de.zoom.opskyblock.helpers;

import de.zoom.opskyblock.OPSkyblockPlugin;
import de.zoom.opskyblock.api.island.impl.basic.BasicIsland;
import de.zoom.opskyblock.api.island.impl.basic.BasicIslandId;
import lombok.experimental.UtilityClass;

import javax.annotation.Nonnull;
import java.util.Optional;

@UtilityClass
public final class IslandHelper {
  static {
    if (OPSkyblockPlugin.getInstance().getDataHelper() == null) {
      throw new RuntimeException("Failed to initialize IslandHelper due to DataHelper not being present.");
    }
  }

  @Nonnull
  public static Optional<BasicIsland> getBasicIsland(@Nonnull final BasicIslandId.IdType type, @Nonnull final String value) {
    return OPSkyblockPlugin.getInstance().getDataHelper().get(new BasicIslandId(type, value));
  }
}
