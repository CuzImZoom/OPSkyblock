package de.zoom.opskyblock.api.island.impl.basic;

import de.zoom.opskyblock.api.data.ModelId;

import javax.annotation.Nonnull;

public class BasicIslandId implements ModelId<BasicIsland> {
  @Nonnull
  private final String key, value;

  public BasicIslandId(@Nonnull final IdType idType, @Nonnull final String value) {
    this.key = idType.getKey();
    this.value = value;
  }

  @Nonnull
  @Override
  public String getKey() {
    return key;
  }

  @Nonnull
  @Override
  public String getValue() {
    return value;
  }

  @Nonnull
  @Override
  public Class<BasicIsland> getModelClass() {
    return BasicIsland.class;
  }

  public enum IdType {
    OWNER_UUID("ownerUUID"),
    ISLAND_UUID("islandUUID");

    @Nonnull
    public final String key;

    IdType(@Nonnull final String key) {
      this.key = key;
    }

    @Nonnull
    public String getKey() {
      return key;
    }
  }
}
