public class ThreadA extends Thread {
    private HasSelfPrivateNum num;

    public ThreadA(HasSelfPrivateNum num){
        super();
        this.num = num;
    }
    @Override
    public void run() {
        super.run();
        num.addI("a");
    }
}
