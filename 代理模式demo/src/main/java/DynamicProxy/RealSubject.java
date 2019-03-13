package DynamicProxy;

/**
 * @Author: neverX2017
 * @Description:
 */
public class RealSubject implements Subject {
    @Override
    public void doOperation() {
        System.out.println("RealSubject doOperation...");
    }
}
