### dubbo testing project

测试dubbo的boot starter和测试方法

结论：
- 不能在同一个项目中直接引用同项目的另外一个dubbo服务，因为此时dubbo还没有完成启动，无法引用到
- 测试框架中，需要在application.properties中添加dobbo的配置信息：
```
dubbo.application.name=dubbotest
dubbo.registry.address=zookeeper://116.62.16.229:2181
```
否则无法引用到service，或者在@Reference中直接标注：
```
    @Reference(url="dubbo://192.168.1.87:20880")

```
