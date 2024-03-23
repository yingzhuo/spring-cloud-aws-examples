# cloud-aws-lambda

## 参考资料

* [spring-cloud-function 官方文档](https://docs.spring.io/spring-cloud-function/reference/spring-cloud-function/introduction.html)

## 注意事项

### (1) 环境变量

```properties
# AWS Console 页面配置
MAIN_CLASS=examples.Application
```

### (2) handler

```text
org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest
```
