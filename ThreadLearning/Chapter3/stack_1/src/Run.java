/**
 * 一生产者一消费者的栈操作。
 */
public class Run {
    public static void main(String args[]) throws InterruptedException {
        MyStack myStack = new MyStack();
        P p = new P(myStack);
        C c = new C(myStack);
        ThreadA a = new ThreadA(p);
        ThreadB b = new ThreadB(c);
        a.start();
        b.start();
    }
}
