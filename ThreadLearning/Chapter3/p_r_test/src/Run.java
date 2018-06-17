/**
 * 一生产者一消费者模式
 */
public class Run {
    public static void main(String args[]){
        Object object = new Object();
        P p = new P(object);
        C c = new C(object);
        ThreadA a = new ThreadA(p);
        ThreadB b = new ThreadB(c);
        a.start();
        b.start();
    }
}
