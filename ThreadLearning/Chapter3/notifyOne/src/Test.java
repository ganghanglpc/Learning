/**
 * 只通知随机一个线程
 * 改用notifyAll()唤醒所有线程。
 */
public class Test {
    public static void main(String args[]){
        try {
            Object object = new Object();
            ThreadA a = new ThreadA(object);
            a.start();
            ThreadB b = new ThreadB(object);
            b.start();
            ThreadC c = new ThreadC(object);
            c.start();
            Thread.sleep(1000);
            NotifyThread notifyThread = new NotifyThread(object);
            notifyThread.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
