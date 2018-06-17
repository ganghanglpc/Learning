package test1;

/**
 * 对同一个对象的锁调用，呈同步效果。
 */
public class Run {
    public static void main(String args[]){
        MyObject object = new MyObject();
        Service service = new Service();
        ThreadA threadA = new ThreadA(service,object);
        ThreadB threadB = new ThreadB(service,object);
        threadA.setName("a");
        threadB.setName("b");
        threadA.start();
        threadB.start();
    }
}
