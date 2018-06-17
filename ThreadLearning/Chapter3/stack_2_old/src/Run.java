/**
 * 一生产者多消费者的栈操作。
 * 修改方法：将if改为while，因为notify有可能唤醒同类线程。
 */
public class Run {
    public static void main(String args[]) throws InterruptedException {
        MyStack myStack = new MyStack();
        P p = new P(myStack);
        C c1 = new C(myStack);
        C c2 = new C(myStack);
        C c3 = new C(myStack);
        C c4 = new C(myStack);
        C c5 = new C(myStack);
        ThreadA a = new ThreadA(p);
        ThreadB b1 = new ThreadB(c1);
        ThreadB b2 = new ThreadB(c2);
        ThreadB b3 = new ThreadB(c3);
        ThreadB b4 = new ThreadB(c4);
        ThreadB b5 = new ThreadB(c5);
        a.start();
        b1.start();
        b2.start();
        b3.start();
        b4.start();
        b5.start();
    }
}
