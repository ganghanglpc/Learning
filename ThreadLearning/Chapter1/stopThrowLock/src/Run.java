/**
 * 使用stop导致释放锁之后的数据不一致现象。
 * 所以stop方法已经被弃用。
 */
public class Run {
    public static void main(String args[]){
        try {
            SynchronisedObject synchronisedObject = new SynchronisedObject();
            MyThread myThread = new MyThread(synchronisedObject);
            myThread.start();
            Thread.sleep(1000);
            myThread.stop();
            System.out.println("username = " + synchronisedObject.getUsername() + " password = " + synchronisedObject.getPassword());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
