package de.zoom.opskyblock.api.data;

import javax.annotation.Nonnull;

public interface ModelId<T extends Model> {
  @Nonnull
  String getKey();
  @Nonnull
  String getValue();
  @Nonnull
  Class<T> getModelClass();

  static ModelId<?> empty() {
    return new ModelId<Model>() {
      @Nonnull
      @Override
      public String getKey() {
        return "_id";
      }

      @Nonnull
      @Override
      public String getValue() {
        return "empty";
      }

      @Nonnull
      @Override
      public Class<Model> getModelClass() {
        return Model.class;
      }
    };
  }
}
