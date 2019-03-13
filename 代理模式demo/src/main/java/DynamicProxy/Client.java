package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: neverX2017
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        //创建被代理的对象 realSubject
        RealSubject realSubject = new RealSubject();
        //创建被代理对象的处理对象
        InvocationHandler handler = new JDKInvocationHandler(realSubject);
        //创建代理对象
        Subject proxy = (Subject) Proxy.newProxyInstance(
                RealSubject.class.getClassLoader(),
                RealSubject.class.getInterfaces(),
                handler);
        //执行相应的方法
        proxy.doOperation();
    }
}

//Proxy 静态方法的定义如下：
//public static Object newProxyInstance(ClassLoader loader,
//        Class<?>[] interfaces,
//        InvocationHandler h)

//loader 为类加载器，出于安全性，要求 loader 对 interfaces 可见，通常使用被代理类的ClassLoader。
//interfaces 为被代理对象需要实现的所有接口。
//h为方法调用的实际处理者，通过 InvocationHandler 对被代理类进行拓展。

