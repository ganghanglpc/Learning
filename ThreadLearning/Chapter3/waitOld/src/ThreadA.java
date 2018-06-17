public class ThreadA extends Thread {
    private Add p ;

    public ThreadA(Add p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.add();
    }
}
