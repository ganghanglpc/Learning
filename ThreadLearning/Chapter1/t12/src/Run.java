/**
 * interrput并未真正中断线程，而是打上一个标记
 */
public class Run {
    public static void main(String args[]){
        try{
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(1000);
            myThread.interrupt();
            System.out.println("是否停止1" + myThread.interrupted());
            System.out.println("是否停止2" + myThread.interrupted());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
