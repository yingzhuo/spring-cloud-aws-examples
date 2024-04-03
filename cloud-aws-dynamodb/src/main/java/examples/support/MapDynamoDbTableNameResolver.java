package examples.support;

import io.awspring.cloud.dynamodb.DynamoDbTableNameResolver;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yingzhuo
 */
public class MapDynamoDbTableNameResolver implements DynamoDbTableNameResolver {

    /**
     * new instance of this class
     *
     * @return instance
     */
    public static MapDynamoDbTableNameResolver newInstance() {
        return new MapDynamoDbTableNameResolver();
    }

    // key: FQN of type
    // value: table name
    private final Map<String, String> map = new HashMap<>();

    /**
     * private construct
     */
    private MapDynamoDbTableNameResolver() {
        super();
    }

    @Override
    public <T> String resolve(Class<T> clazz) {
        Assert.notNull(clazz, "clazz is null");
        final var tableName = this.map.get(clazz.getName());
        if (tableName == null) {
            throw new IllegalArgumentException("no table name found");
        }
        return tableName;
    }

    public MapDynamoDbTableNameResolver addSimpleNameMapping(Class<?> clazz) {
        Assert.notNull(clazz, "clazz is null");
        this.map.put(clazz.getName(), clazz.getSimpleName());
        return addMapping(clazz, clazz.getSimpleName());
    }

    public MapDynamoDbTableNameResolver addMapping(Class<?> clazz, String tableName) {
        Assert.notNull(clazz, "clazz is null");
        Assert.hasText(tableName, "table name is null or blank");
        this.map.put(clazz.getName(), tableName);
        return this;
    }

    public Map<String, String> getMappings() {
        return Collections.unmodifiableMap(map);
    }

}
