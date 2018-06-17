/**
 * 锁的重入
 */
public class Run {

    public static void main(String args[]){
        Service service = new Service();
        MyThread myThread = new MyThread(service);
        myThread.start();
    }
}
