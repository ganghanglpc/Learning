public class ThreadA extends Thread {
    ThreadB b;

    public ThreadA(ThreadB b) {
        this.b = b;
    }

    @Override
    public void run() {
        super.run();
        try{
            synchronized (b){
                b.start();
                Thread.sleep(6000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
