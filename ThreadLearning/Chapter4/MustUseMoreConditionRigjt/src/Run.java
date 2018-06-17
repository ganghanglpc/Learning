/**
 * 使用多个Condition实现等待/通知的正确用法
 * 可以让一个Condition对应一个线程，实现一对一唤醒。
 */
public class Run {
    public static void main(String args[]){
        try {
            MyService service = new MyService();
            ThreadA a = new ThreadA(service);
            a.setName("A");
            a.start();
            ThreadB b = new ThreadB(service);
            b.setName("B");
            b.start();
            Thread.sleep(3000);
            service.signalAll_A();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
