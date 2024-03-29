# 动态代理
与静态代理需要事先构建不同，动态代理是动态地在内存中生成的。一般而言，动态代理可以由 JDK 动态代理及CGLib 动态代理实现。
# JDK动态代理
使用JDK动态代理只需要3步即可完成：
1. 创建被代理的对象 RealSubject
2. 创建被代理对象的处理对象，持有目标（被代理）对象 JDKInvocationHandler
3. 使用Proxy的静态方法 newProxyInstance 创建代理对象
### 问：
为什么 JDK 实现动态代理必须要求被代理类实现接口？
### 答：
这是由于动态代理动态生成的代理类需要继承 Proxy 类，
而 Java 中只能单继承的限制使得被代理类必须实现接口才能实现动态代理。
# CGLib
CGLib 是一个强大的高性能的代码生成包，
它可以在运行期扩展 Java 类及实现Java接口、提供方法的拦截，
因此被众多 AOP 框架使用。
CGLib 包的底层是通过使用字节码处理框架 ASM 来转换字节码并生成新的类。  

使用 CGLib 实现动态代理也很简单：
1. 创建Enhancer对象
2. 设置被代理类
3. 回调对象（回调类实现 MethodInterceptor或InvocationHandler接口）
4. 创建并设置回调对象
5. 创建代理对象

### 问：
既然JDK动态代理要求被代理类必须实现接口，而CGLib要求被代理类不能是final类，那么能不能为没有实现接口的final类进行动态代理呢？
### 答：
答案是不能，但是可以通过反射来实现类似动态代理的功能。

---
注：根据[此文](https://www.jianshu.com/p/992dfcecff34)进行复现
