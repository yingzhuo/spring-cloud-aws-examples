package examples.support;

import io.awspring.cloud.dynamodb.DynamoDbTableNameResolver;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SmartDynamoDbTableNameResolver implements DynamoDbTableNameResolver, InitializingBean {

    private final Map<Class<?>, String> mappings = new HashMap<>();
    private final DefaultStyle defaultStyle;

    @Nullable
    private String tablePrefix;

    @Nullable
    private String tableSuffix;

    public SmartDynamoDbTableNameResolver() {
        this(DefaultStyle.CLASS_NAME);
    }

    public SmartDynamoDbTableNameResolver(DefaultStyle defaultStyle) {
        Assert.notNull(defaultStyle, "defaultStyle is required");
        this.defaultStyle = defaultStyle;
    }

    public void addMapping(Class<?> clz, String tableName) {
        mappings.put(clz, tableName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (defaultStyle == DefaultStyle.CLASS_NAME) {
            this.tablePrefix = null;
            this.tableSuffix = null;
        }
    }

    @Override
    public <T> String resolve(Class<T> clazz) {
        Assert.notNull(clazz, "clazz is required");

        var tableName = mappings.get(clazz);
        if (tableName != null) {
            return tableName;
        }

        return switch (defaultStyle) {
            case CLASS_NAME -> toClassNameStyle(clazz);
            case UNDERSCORE -> toUnderscoreStyle(clazz);
        };
    }

    private String toClassNameStyle(Class<?> clazz) {
        return clazz.getSimpleName();
    }

    private String toUnderscoreStyle(Class<?> clazz) {
        var prefix = StringUtils.hasText(tablePrefix) ? tablePrefix : "";
        var suffix = StringUtils.hasText(tableSuffix) ? tableSuffix : "";
        return prefix.concat(clazz.getSimpleName().replaceAll("(.)(\\p{Lu})", "$1_$2").toLowerCase(Locale.ROOT))
                .concat(suffix);
    }

    public void setTablePrefix(@Nullable String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public void setTableSuffix(@Nullable String tableSuffix) {
        this.tableSuffix = tableSuffix;
    }

    public static enum DefaultStyle {
        CLASS_NAME,
        UNDERSCORE;
    }

}
