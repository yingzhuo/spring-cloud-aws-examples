## cloud-aws-dynamodb

### 参考资料

* [spring-cloud-aws 官方文档](https://docs.awspring.io/spring-cloud-aws/docs/3.0.0/reference/html/index.html#spring-cloud-aws-dynamoDb)

### 代码片段

```java
// 创建对象
final var cp=ContactPerson.builder()
        .pk("1")
        .sk("1")
        .name("应卓")
        .phoneNumber("18916944373")
        .email("yingzhor@gmail.com")
        .build();

        template.save(cp);

        System.out.println("存储对象成功");
```

```java
// 查找对象
final var cp=template.load(
        Key.builder()
        .partitionValue("1")
        .sortValue("1")
        .build(),
        ContactPerson.class);
```

```java
// 删除对象
template.delete(Key.builder()
        .partitionValue("1")
        .sortValue("1")
        .build(),ContactPerson.class);
```

```java
// 更新对象
var cp=ContactPerson.builder()
        .pk("1")
        .sk("1")
        .name("应卓")
        .phoneNumber("189xxxx4373")
        .email("yingzhor@gmail.com")
        .build();

        cp=template.update(cp);
```