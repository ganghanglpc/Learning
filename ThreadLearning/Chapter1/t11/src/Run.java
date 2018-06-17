/**
 * interrput并未真正中断线程，而是打上一个标记
 */
public class Run {
    public static void main(String args[]){
        try{
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(2000);
            myThread.interrupt();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
