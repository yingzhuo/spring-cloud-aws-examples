## spring-cloud-aws-examples

* [cloud-aws-lambda](/cloud-aws-lambda)
* [cloud-aws-dynamodb](/cloud-aws-dynamodb)

## 参考资料

* [spring-cloud-aws 官方文档](https://docs.awspring.io/spring-cloud-aws/docs/3.1.1/reference/html/index.html#using-amazon-web-services)

## 关于秘钥

出于安全隐私安全考虑。本人开发和运行本项目的程序时，不会把AWS相关的秘钥或密码展示在本项目的代码或配置文件中，如果您需要运行本项目中的程序，请确保密码正确地在本地配置。

* `~/.aws/credentials`

```
[default]
aws_access_key_id=<your aws access key id>
aws_secret_access_key=<your aws secret access key>
```

* `~/.aws/config`

```
[default]
region=<your region>
```
