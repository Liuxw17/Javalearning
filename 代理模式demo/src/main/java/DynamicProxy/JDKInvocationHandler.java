package DynamicProxy;

import java.lang.reflect.Method;

/**
 * @Author: neverX2017
 * @Description:
 */
public class JDKInvocationHandler implements java.lang.reflect.InvocationHandler{
    private Subject subject;
    public JDKInvocationHandler(Subject subject) {
        this.subject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDKProxy before RealSubject doOperation...");
        Object ret = method.invoke(subject, args);
        System.out.println("JDKProxy after RealSubject doOperation...");
        return ret;
    }
}

//1. 创建被代理的对象 RealSubject
//2. 创建被代理对象的处理对象，持有目标（被代理）对象 JDKInvocationHandler
//3. 使用Proxy的静态方法 newProxyInstance 创建代理对象

//InvocationHandler 是 Java 自带的接口，其定义如下：
//public interface InvocationHandler {
//    public Object invoke(Object proxy, Method method, Object[] args)
//            throws Throwable;
//}