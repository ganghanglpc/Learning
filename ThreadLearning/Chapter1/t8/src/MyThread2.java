public class MyThread2 extends Thread{
    @Override
    public void run() {
        super.run();
        try{
            System.out.println("run threadName=" + this.currentThread().getName() +  "begin");
            Thread.sleep(1000);
            System.out.println("run threadName=" + this.currentThread().getName() + "end");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
