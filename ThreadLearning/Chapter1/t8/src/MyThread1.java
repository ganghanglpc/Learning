public class MyThread1 extends Thread {
    @Override
    public void run() {
        super.run();
        try{
            System.out.println("run threadName=" + Thread.currentThread().getName() +  "begin");
            Thread.sleep(1000);
            System.out.println("run threadName=" + Thread.currentThread().getName() + "end");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
