/**
 * synchronised同步方法太浪费时间了。
 */
public class Run {
    public static void main(String args[]){
        Task task = new Task();
        MyThread1 thread1 = new MyThread1(task);
        MyThread2 thread2 = new MyThread2(task);
        thread1.start();
        thread2.start();
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long biginTime = Commonutils.beginTime1;
        if(Commonutils.beginTime2 <  Commonutils.beginTime1){
            biginTime = Commonutils.beginTime2;
        }
        long endTime = Commonutils.endTime1;
        if(Commonutils.endTime2 > Commonutils.endTime1){
            endTime = Commonutils.endTime2;
        }
        System.out.println("耗时：" + ((endTime - biginTime)/1000));
    }
}
