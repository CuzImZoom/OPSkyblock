package de.zoom.opskyblock.api.island.impl.basic;

import de.zoom.opskyblock.api.data.StoredGroup;
import de.zoom.opskyblock.api.island.Island;
import lombok.Data;

import java.util.UUID;

@Data
@StoredGroup("islands")
public class BasicIsland implements Island {
  private final UUID ownerUUID, islandUUID;
}
