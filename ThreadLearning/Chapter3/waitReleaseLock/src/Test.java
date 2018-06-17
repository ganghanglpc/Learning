/**
 * wait()之后释放锁
 * 如果将wait()方法改为sleep方法，就成了同步效果。
 */
public class Test {
    public static void main(String args[]){
        Object object = new Object();
        ThreadA a = new ThreadA(object);
        a.start();
        ThreadB b = new ThreadB(object);
        b.start();
    }
}
