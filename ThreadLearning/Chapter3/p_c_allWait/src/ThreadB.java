public class ThreadB extends Thread {
    private C c;

    public ThreadB(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            c.getValue();
        }
    }
}
