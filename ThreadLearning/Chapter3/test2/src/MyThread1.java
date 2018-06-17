public class MyThread1 extends Thread {
    private Object lock;

    public MyThread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        try{
            synchronized (lock){
                System.out.println("开始   waite time = " + System.currentTimeMillis());
                lock.wait();
                System.out.println("结束   waite time = " + System.currentTimeMillis());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
