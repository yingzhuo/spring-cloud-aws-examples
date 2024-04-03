# cloud-aws-lambda

## 思考在前

您真的必须在`AWS Lambda`中使用 `spring-boot`，`spring`，`spring-cloud`等框架吗？用[Google Guice](https://github.com/google/guice)好不好呀？如果您还是确定你需要`spring`系的东西，您可以参考本项目了。
再或者，您必须使用`Java`语言开发这个功能吗？

## 参考资料

* [AWS lambda - Java语言相关](https://docs.aws.amazon.com/lambda/latest/dg/java-package.html)
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
