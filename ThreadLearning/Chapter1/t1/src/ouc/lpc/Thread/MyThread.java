package ouc.lpc.Thread;

/**
 * 实现继承Thread类
 * 或者实现runnable接口
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("mythread");
    }
}
