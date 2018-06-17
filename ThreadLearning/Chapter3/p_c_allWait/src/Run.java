/**
 * 多生产者多消费者模式
 * 有可能进入“假死”状态
 * ☆☆☆☆“假死”出现的主要原因是因为唤醒可能唤醒同类！☆☆☆☆
 * 解决假死：唤醒所有类，即notifyAll
 */
public class Run {
    public static void main(String args[]) throws InterruptedException {
        Object object = new Object();
        P p = new P(object);
        C c = new C(object);
        ThreadA[] P = new ThreadA[2];
        ThreadB[] C = new ThreadB[2];
        for (int i = 0;i < 2;i ++) {
            P[i] = new ThreadA(p);
            P[i].setName("生产者" + (i + 1));
            C[i] = new ThreadB(c);
            C[i].setName("消费者" + (i + 1));
            P[i].start();
            C[i].start();
        }
        Thread.sleep(5000);
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for (int i = 0; i < threads.length; i ++){
            System.out.println(threads[i].getName() + " " + threads[i].getState());
        }
    }
}
