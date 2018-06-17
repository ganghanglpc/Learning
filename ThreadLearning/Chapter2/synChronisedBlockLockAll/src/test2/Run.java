package test2;


/**
 * 当调用加锁对象x的时候，其他线程无法调用x的同步方法，但是可以调用非同步方法。
 */
public class Run {
    public static void main(String args[]) throws InterruptedException {
        MyObject object = new MyObject();
        Service service = new Service();
        ThreadA threadA = new ThreadA(service,object);
        ThreadB threadB = new ThreadB(service,object);
        threadA.setName("a");
        threadB.setName("b");
        threadA.start();
        Thread.sleep(100);
        threadB.start();
    }
}
