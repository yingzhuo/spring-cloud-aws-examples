package examples;

import io.awspring.cloud.dynamodb.DynamoDbTableNameResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationDynamoDb {

    @Bean
    public DynamoDbTableNameResolver dynamoDbTableNameResolver() {
        return new DynamoDbTableNameResolver() {
            @Override
            public <T> String resolve(Class<T> clazz) {
                return clazz.getSimpleName();
            }
        };
    }

}
