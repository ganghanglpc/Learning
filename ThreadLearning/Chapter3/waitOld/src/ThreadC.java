public class ThreadC extends Thread {
    private Subtract r;

    public ThreadC(Subtract r) {
        this.r = r;
    }

    @Override
    public void run() {
        r.subtract();
    }
}
