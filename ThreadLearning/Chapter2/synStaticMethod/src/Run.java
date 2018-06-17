/**
 * 在静态方法上加锁，是给这个class类都加了锁。
 * 在非静态方法上加锁，是给某个对象加锁。
 */
public class Run {
    public static void main(String args[]){
        ThreadA a = new ThreadA();
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB();
        b.setName("B");
        b.start();
    }
}
