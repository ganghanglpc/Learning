/**
 * 多生产者一消费者：操作栈
 */
public class Run {
    public static void main(String args[]) throws InterruptedException {
        MyStack myStack = new MyStack();
        P p1 = new P(myStack);
        P p2 = new P(myStack);
        P p3 = new P(myStack);
        P p4 = new P(myStack);
        C c1 = new C(myStack);

        ThreadA a1 = new ThreadA(p1);
        ThreadA a2 = new ThreadA(p2);
        ThreadA a3 = new ThreadA(p3);
        ThreadA a4 = new ThreadA(p4);
        ThreadB b1 = new ThreadB(c1);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        b1.start();
    }
}
