/**
 * 使用多个Condition实现等待/通知的错误用法
 * 唤醒后A B都醒了，我只想唤醒某一个线程。
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
            service.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
