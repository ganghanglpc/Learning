package test;

import mythread.MyThread;

/**
 * 多线程第二个例子
 */
public class Test {

    public static void main(String args[]){
        try {
            MyThread myThread = new MyThread();
            myThread.setName("myThread");

            // start()启动的顺序并不代表线程运行的顺序，它只是说明线程进入了预备状态
            myThread.start();
            for(int i = 0;i < 10;i ++){
                int time = (int)(Math.random()*1000);
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
