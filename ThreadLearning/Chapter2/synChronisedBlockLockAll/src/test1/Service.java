package test1;

public class Service {
    public void testMethod1(MyObject object){
        synchronized (object){
            try{
                System.out.println("testMethod1 ____getLock time=" + System.currentTimeMillis() + " run ThreadName=" + Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("testMethod1 ____releaseLock time=" + System.currentTimeMillis() + " run ThreadName=" + Thread.currentThread().getName());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
