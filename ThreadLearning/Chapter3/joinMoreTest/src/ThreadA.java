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
                System.out.println("begin A ThreadName=" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("end A ThreadName=" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
