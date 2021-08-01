package de.zoom.opskyblock.api.data.impl;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import de.zoom.opskyblock.api.data.DataHelper;
import de.zoom.opskyblock.api.data.Model;
import de.zoom.opskyblock.api.data.ModelId;

import javax.annotation.Nonnull;
import java.util.Optional;

public class MongoDataHelper implements DataHelper {
  private final MongoClient mongo;
  private final MongoDatabase db;

  public MongoDataHelper(@Nonnull final String mongoURI, @Nonnull final String database) {
    this.mongo = new MongoClient(new MongoClientURI(mongoURI));
    this.db = mongo.getDatabase(database);
  }

  @Nonnull
  @Override
  public <T extends Model> Optional<T> get(@Nonnull ModelId<T> id) {
    return Optional.empty();
  }

  @Override
  public <T extends Model> void set(@Nonnull ModelId<T> id, @Nonnull T value) {

  }

  @Override
  public void delete(@Nonnull ModelId<?> id) {

  }

  @Override
  public boolean exists(@Nonnull ModelId<?> id) {
    return false;
  }

  @Override
  public void close() {
    mongo.close();
  }
}
