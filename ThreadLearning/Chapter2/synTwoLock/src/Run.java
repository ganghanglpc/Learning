/**
 * 静态方法加锁是对该类加锁
 */
public class Run {

    public static void main(String args[]){
        Service service1 = new Service();
        Service service2 = new Service();
        ThreadA a = new ThreadA(service1);
        a.setName("A");
        ThreadB b = new ThreadB(service2);
        b.setName("B");
        a.start();
        b.start();
    }
}
