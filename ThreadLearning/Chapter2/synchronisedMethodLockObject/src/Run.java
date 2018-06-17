/**
 * 当一个线程使用A对象的同步方法
 * 另一个线程可以继续使用A对象的非同步方法。
 * 但是另一个线程调用其他同步方法或者同步(this）代码块时，必须等待
 */
public class Run {

    public static void main(String args[]){
        MyObject object = new MyObject();
        ThreadA threadA = new ThreadA(object);
        threadA.start();
        ThreadB threadB = new ThreadB(object);
        threadB.start();
    }
}
