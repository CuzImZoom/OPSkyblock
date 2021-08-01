package de.zoom.opskyblock.api.data;

import me.lucko.helper.terminable.Terminable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

public interface DataHelper extends Terminable {
  @Nonnull
  <T extends Model> Optional<T> get(@Nonnull ModelId<T> id); // <T> creates a new generic type for this method, T is a type of any object

  <T extends Model> void set(@Nonnull ModelId<T> id, @Nonnull final T value);

  void delete(@Nonnull ModelId<?> id);

  boolean exists(@Nonnull ModelId<?> id);

  void close();
}
