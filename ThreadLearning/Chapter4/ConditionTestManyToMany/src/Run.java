/**
 * 多产者多消费者  ------  通过 Condition实现。
 */
public class Run {
    public static void main(String args[]){
        MyService service = new MyService();
        ThreadA a1 = new ThreadA(service);
        ThreadA a2 = new ThreadA(service);
        ThreadA a3 = new ThreadA(service);
        ThreadB b1 = new ThreadB(service);
        ThreadB b2 = new ThreadB(service);
        ThreadB b3 = new ThreadB(service);
        a1.start();
        a2.start();
        a3.start();
        b1.start();
        b2.start();
        b3.start();
    }
}
