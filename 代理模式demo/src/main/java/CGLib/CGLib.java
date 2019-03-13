package CGLib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;


/**
 * @Author: neverX2017
 * @Description:
 */
public class CGLib {
    public static void main(String[] args) {
        // 创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        // 设置被代理类
        enhancer.setSuperclass(ConcreteSubject.class);

        // 创建回调对象

        //1 实现 MethodInterceptor 接口
//        Callback callback = (Callback) new CGLibMethodInterceptor();
        //2 实现 InvocationHandler 接口
        Callback callback = new CGLibInvocationHandler(new ConcreteSubject());

        // 设置回调对象
        enhancer.setCallback((net.sf.cglib.proxy.Callback) callback);
        // 创建代理对象
        ConcreteSubject subject = (ConcreteSubject) enhancer.create();
        subject.doOperation();
    }
}