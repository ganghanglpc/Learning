public class ThreadBB extends Thread {
    private Service service;

    public ThreadBB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.methodB();
    }
}
