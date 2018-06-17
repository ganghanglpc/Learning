/**
 * 子类对父类锁的重入
 */
public class Run {
    public static void main(String args[]){
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
