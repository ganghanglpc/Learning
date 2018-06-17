/**
 * i-- 与 System,out,println()的异常
 * i--操作： 1 取数 2 改值 3 写回 非线程安全。
 * System,out,println中有自减，自增操作时，先执行自减，自增操作。
 */
public class Run {

    public static void main(String args[]){
        MyThread run = new MyThread();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        Thread t4 = new Thread(run);
        Thread t5 = new Thread(run);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
