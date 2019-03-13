package 代理模式;

/**
 * @Author: neverX2017
 * @Description:
 */

public class Proxy implements Subject {
    private Subject subject;
    public Proxy(Subject subject) {
        this.subject = subject;
    }
    @Override
    public void doOperation() {
        System.out.println("Proxy before RealSubject doOperation...");
        subject.doOperation();
        System.out.println("Proxy after RealSubject doOperation...");
    }
}

