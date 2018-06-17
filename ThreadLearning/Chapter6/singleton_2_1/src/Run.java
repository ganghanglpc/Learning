/**
 * 懒汉模式 出现了多线程的安全问题，创建出了多例
 * 解决方案1： 加入synchronised方法关键字
 * 缺点：效率太低
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
