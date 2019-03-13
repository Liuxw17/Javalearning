package 代理模式;

/**
 * @Author: neverX2017
 * @Description:
 */
public class Client {
    public static void main(String[] args){
        Subject subject = new Proxy(new RealSubject());
        subject.doOperation();
    }
}
