## 一、说明
- 该SDK是对 https://www.uduncloud.com/geteway-interface api接口文档的Java版封装

## 二、使用步骤

### 2.1 获取`sdk`

有两种方法

1. 通过本项目自己打包
2. 这里有打包好的`sdk`，直接下载使用

### 2.2 使用`sdk`

请参考 [udun-sdk-java-demo](https://github.com/uduncloud/udun-sdk-java-demo)
主要步骤如下：

1. 将`sdk`拷贝到项目中
2. `pom.xml`引入`sdk`及其依赖包

```
<dependency>
    <groupId>com.udun</groupId>
    <artifactId>udun-sdk-java</artifactId>
    <version>2.0.2</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/src/lib/udun-sdk-java-2.0.2.jar</systemPath>
</dependency>
<dependency>
    <groupId>cn.hutool</groupId>
    <artifactId>hutool-all</artifactId>
    <version>5.4.0</version>
</dependency>
```

3. 具体用法参考 https://github.com/uduncloud/java-wallet-sdk/blob/main/src/test/java/UdunclientDemo.java，所有方法参考 https://github.com/uduncloud/java-wallet-sdk/blob/main/src/main/java/com/udun/sdk/client/UdunApi.java


参数解释：

- gateway：优盾网关
- merchant-id：商户号
- merchant-key：商户加密key
- call-url：充提币回调地址

4. 注入`UdunService`，使用`service`中的方法对接优盾# udun-sdk-java

