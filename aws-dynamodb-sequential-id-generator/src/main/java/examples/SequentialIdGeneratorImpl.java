package examples;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ReturnValue;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@SuppressWarnings("ConstantConditions")
public class SequentialIdGeneratorImpl implements SequentialIdGenerator {

    private final DynamoDbClient client;
    private final String tableName;
    private final String pkAttributeName;
    private final String pkFixedValue;
    private final String skAttributeName;   // maybe null
    private final String skFixedValue;      // maybe null
    private final String indexAttributeName;
    private final int step;

    @Override
    public BigInteger next() {
        var primaryKey = getPrimaryKey();
        var expNames = getExpressionNames();
        var expValues = getExpressionValues();

        var request = UpdateItemRequest.builder()
                .tableName(tableName)
                .key(primaryKey)
                .updateExpression("SET #index = #index + :step")
                .expressionAttributeNames(expNames)
                .expressionAttributeValues(expValues)
                .returnValues(ReturnValue.UPDATED_NEW)
                .build();

        var response = client.updateItem(request);
        var attributes = response.attributes();
        return new BigInteger(attributes.get(this.indexAttributeName).n());
    }

    private Map<String, AttributeValue> getPrimaryKey() {
        var map = new HashMap<String, AttributeValue>();
        map.put(pkAttributeName, AttributeValue.builder().s(pkFixedValue).build());

        if (skAttributeName != null && skFixedValue != null) {
            map.put(skAttributeName, AttributeValue.builder().s(skFixedValue).build());
        }
        return map;
    }

    private Map<String, String> getExpressionNames() {
        return Map.of("#index", indexAttributeName);
    }

    private Map<String, AttributeValue> getExpressionValues() {
        return Map.of(":step", AttributeValue.builder().n(String.valueOf(step)).build());
    }

}
