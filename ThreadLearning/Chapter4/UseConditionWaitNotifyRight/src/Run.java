/**
 * 使用Condition来实现等待/通知的正确示范
 * 需要在锁的情况下使用。
 */
public class Run {
    public static void main(String args[]){
        try {
            MyService service = new MyService();
            ThreadA a = new ThreadA(service);
            a.start();
            Thread.sleep(3000);
            service.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
