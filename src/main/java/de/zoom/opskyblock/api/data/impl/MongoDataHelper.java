package de.zoom.opskyblock.api.data.impl;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import de.zoom.opskyblock.api.data.DataHelper;
import de.zoom.opskyblock.api.data.Model;
import de.zoom.opskyblock.api.data.ModelId;
import de.zoom.opskyblock.api.data.StoredGroup;
import me.lucko.helper.gson.GsonProvider;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.annotation.Nonnull;
import java.util.Objects;
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
    final FindIterable<Document> docs = getCollection(id.getModelClass()).find(Filters.eq(id.getKey(), id.getValue()));

    if(!docs.cursor().hasNext()) {
      return Optional.empty();
    }

    return Optional.ofNullable(GsonProvider.standard().fromJson(Objects.requireNonNull(docs.first()).toJson(), id.getModelClass()));
  }

  @Override
  public <T extends Model> void set(@Nonnull ModelId<T> id, @Nonnull T value) {
    final MongoCollection<Document> collection = getCollection(id.getModelClass());
    final Bson filter = Filters.eq(id.getKey(), id.getValue());
    final Document document = Document.parse(GsonProvider.standard().toJson(value));

    if(exists0(collection, filter)) {
      collection.replaceOne(filter, document);
    } else {
      collection.insertOne(document);
    }
  }

  @Override
  public void delete(@Nonnull ModelId<?> id) {
    getCollection(id.getModelClass()).deleteOne(Filters.eq(id.getKey(), id.getValue()));
  }

  @Override
  public boolean exists(@Nonnull ModelId<?> id) {
    return exists0(getCollection(id.getModelClass()), Filters.eq(id.getKey(), id.getValue()));
  }

  private boolean exists0(@Nonnull MongoCollection<Document> collection, @Nonnull Bson filter) {
    return collection.find(filter).cursor().hasNext();
  }

  @Nonnull
  private MongoCollection<Document> getCollection(@Nonnull Class<?> type) {
    final StoredGroup annotation = type.getAnnotation(StoredGroup.class);

    return db.getCollection(annotation != null ? annotation.value() : "default");
  }

  @Override
  public void close() {
    mongo.close();
  }
}
