public class ThreadB extends Thread {
    private Subtract r;

    public ThreadB(Subtract r) {
        this.r = r;
    }

    @Override
    public void run() {
        r.subtract();
    }
}
