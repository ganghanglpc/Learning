public class ThreadAA extends Thread {
    private Service service;

    public ThreadAA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.methodB();
    }
}
