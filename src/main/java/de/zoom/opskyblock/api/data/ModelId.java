package de.zoom.opskyblock.api.data;

import javax.annotation.Nonnull;

public interface ModelId<T extends Model> {
  @Nonnull
  String getKey();
  @Nonnull
  String getValue();
  @Nonnull
  Class<T> getModelClass();
}
