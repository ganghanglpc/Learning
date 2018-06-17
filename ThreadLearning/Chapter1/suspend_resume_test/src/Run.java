/**
 * suspend 与 resume方法，但是已经被弃用，原因是因为对数据的独占和不同步
 */
public class Run {
    public static void main(String agrs[]){
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(5000);
            //A段
            myThread.suspend();
            System.out.println("A = " + System.currentTimeMillis() + "i =" + myThread.getI());
            Thread.sleep(5000);
            System.out.println("A = " + System.currentTimeMillis() + "i =" + myThread.getI());
            //B段
            myThread.resume();
            Thread.sleep(5000);
            //C段
            myThread.suspend();
            System.out.println("B = " + System.currentTimeMillis() + "i =" + myThread.getI());
            Thread.sleep(5000);
            System.out.println("B = " + System.currentTimeMillis() + "i =" + myThread.getI());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
