package test;

import myrunnable.MyRunnable;
import ouc.lpc.Thread.MyThread;

/**
 * 多线程第一个例子
 * 分别继承Thread与实现Runnable
 */
public class Run {

    public static void main(String args[]){
        /* 继承thread
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("运行结束！");
        */
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        System.out.println("end");
    }
}
