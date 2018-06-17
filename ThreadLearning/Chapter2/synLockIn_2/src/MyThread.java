public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        Sub sub = new Sub();
        sub.operateSubMethod();
    }
}
