/**
 * 懒汉模式 出现了多线程的安全问题，创建出了多例
 * 解决方案4： DCL double-check Locking 双检查机制
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
