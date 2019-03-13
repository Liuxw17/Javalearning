package CGLib;

import net.sf.cglib.proxy.Callback;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: neverX2017
 * @Description:
 */
//回调对象 实现 InvocationHandler
public class CGLibInvocationHandler implements InvocationHandler, Callback {
    private Object realSubject;
    public CGLibInvocationHandler(Object realSubject) {
        super();
        this.realSubject = realSubject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("CGLib before ConcreteSubject doOperation...");
        Object ret = method.invoke(realSubject, args);
        System.out.println("CGLib after ConcreteSubject doOperation...");
        return ret;
    }
}
