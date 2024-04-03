package examples;

import examples.domain.ContactPerson;
import examples.support.MapDynamoDbTableNameResolver;
import io.awspring.cloud.dynamodb.DynamoDbTableNameResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigDynamoDb {

    @Bean
    public DynamoDbTableNameResolver customDynamoDbTableNameResolver() {
        return MapDynamoDbTableNameResolver.newInstance()
                .addSimpleNameMapping(ContactPerson.class);
    }

}
