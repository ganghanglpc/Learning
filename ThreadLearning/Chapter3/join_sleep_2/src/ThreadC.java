public class ThreadC extends ThreadB {
    private ThreadB threadB;

    public ThreadC(ThreadB threadB) {
        this.threadB = threadB;
    }
    @Override
    public void run(){
        threadB.bService();
    }
}
