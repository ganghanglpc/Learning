/**
 * 使用Condition来实现等待/通知的错误示范
 * 需要在锁的情况下使用。
 */
public class Run {
    public static void main(String args[]){
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.start();
    }
}
