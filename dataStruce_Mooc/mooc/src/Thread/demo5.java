package Thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟线程间的通信，如果使用while监测，浪费CPU资源
 */
public class demo5 {

    public static void main(String agrs[]) throws InterruptedException {
        MyList myList = new MyList();
        Object object = new Object();
        TTThread tThread = new TTThread(myList,object);
        tThread.start();
        Thread.sleep(5000);
        TThread ttThread = new TThread(myList,object);
        ttThread.start();

    }
}

class MyList{
    private List list = new ArrayList();
    public void add(){
        list.add("lpc");
    }
    public int getSize(){
        return list.size();
    }
}

class TThread extends Thread{
    private MyList myList;
    private Object lock;
    public TThread(MyList myList,Object lock){
        this.myList = myList;
        this.lock = lock;
    }
    @Override
    public void run(){
        synchronized (lock) {
            for(int i = 0; i < 10;i ++){
                myList.add();
                if(myList.getSize() == 5.){
                    lock.notify();
                    System.out.println("Message have been sent");
                }
                System.out.println(i);
            }
        }
    }
}

class TTThread extends Thread{
    private MyList myList;
    private Object lock;
    public TTThread(MyList myList,Object lock){
        this.myList = myList;
        this.lock = lock;
    }
    @Override
    public void run(){
        synchronized (lock) {
           if(myList.getSize() != 5){
               System.out.println("wait begin");
               try {
                   lock.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("wait end");
           }
        }
    }
}
