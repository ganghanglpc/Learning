/**
 * 在sleep下被中断，会抛出异常，并且停止的状态值会被清除
 */
public class Run {
    public static void main(String args[]){
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(2000);
            myThread.interrupt();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
