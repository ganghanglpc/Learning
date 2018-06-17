public class MyThread extends Thread {
    private int i = 5;

    @Override
    public void run() {
        super.run();
        System.out.println("i=" + (i--) + " threadName=" + Thread.currentThread().getName());
    }
}
