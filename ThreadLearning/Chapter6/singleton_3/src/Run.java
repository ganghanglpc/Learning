/**
 * 懒汉模式 出现了多线程的安全问题，创建出了多例
 * 解决方案3： 加入synchronised同步代码块 加锁部分关键代码
 * 缺点：一样有线程安全问题
 */
public class Run {
    public static void main(String args[]) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}
