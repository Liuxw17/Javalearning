package CGLib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: neverX2017
 * @Description:
 */
//回调对象 实现 MethodInterceptor
public class CGLibMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
            throws Throwable {
        Object ret = null;
        System.out.println("CGLib before ConcreteSubject doOperation...");
        ret = proxy.invokeSuper(obj, args);
        System.out.println("CGLib after ConcreteSubject doOperation...");
        return ret;
    }
}