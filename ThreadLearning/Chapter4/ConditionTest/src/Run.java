/**
 * 一生产者一消费者  ------  通过 Condition实现。
 */
public class Run {
    public static void main(String args[]){
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        ThreadB b = new ThreadB(service);
        a.start();
        b.start();
    }
}
