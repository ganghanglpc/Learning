public class MyThreadB extends Thread {
    private Sub sub;
    public MyThreadB(Sub sub){
        this.sub = sub;
    }

    @Override
    public void run() {
        super.run();
        sub.serviceMethod();
    }
}
