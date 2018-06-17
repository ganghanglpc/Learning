public class ThreadB extends Thread {
    private HasSelfPrivateNum num;

    public ThreadB(HasSelfPrivateNum num){
        super();
        this.num = num;
    }
    @Override
    public void run() {
        super.run();
        num.addI("b");
    }
}
