/**
 * 异常法停止线程
 */
public class Run {
    public static void main(String agrs[]){
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(500);
            myThread.interrupt();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
