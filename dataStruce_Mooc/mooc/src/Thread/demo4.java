package Thread;

/**
 * 测试wait与notify功能
 */
public class demo4 {

    public static void main(String args[]){
        Object lock = new Object();
        testThread testThread = new testThread(lock);
        testThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testNotifyThread testNotifyThread = new testNotifyThread(lock);
        testNotifyThread.start();

    }
}

class testThread extends Thread{
    private Object lock;
    public testThread(Object lock){
        this.lock = lock;
    }
    @Override
    public void run(){
        Service service = new Service();
        service.testWait(lock);
    }
}

class testNotifyThread extends Thread{
    private Object lock;
    public testNotifyThread(Object lock){
        this.lock = lock;
    }
    @Override
    public void run(){
        Service service = new Service();
        service.testNotify(lock);
    }
}

class Service{
    public void testWait(Object lock){
        try {
            synchronized (lock) {
                System.out.println("wait begin");
                lock.wait();
                System.out.println("wait end");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void testNotify(Object lock){
        try{
            synchronized (lock){
                System.out.println("notify begin");
                lock.notify();
                for(int i = 0;i < 5; i ++){
                    Thread.sleep(1000);
                    System.out.println(i);
                }
            }
            System.out.println("notify end");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
