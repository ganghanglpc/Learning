public class Test {
    public static void main(String args[]){
        try{
            Object object = new Object();
            MyThread1 t1 = new MyThread1(object);
            MyThread2 t2 = new MyThread2(object);
            t1.start();
            Thread.sleep(1000);
            t2.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
