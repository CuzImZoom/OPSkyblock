package de.zoom.opskyblock.api.island;

import de.zoom.opskyblock.api.data.Model;

import java.util.UUID;

public interface Island extends Model {
  UUID getOwnerUUID();

  UUID getIslandUUID();
}
