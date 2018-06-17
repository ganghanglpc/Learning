/**
 * 必须执行完notify()之后的代码块之后才会释放锁。
 */
public class Test {
    public static void main(String args[]){
        Object object = new Object();
        ThreadA a = new ThreadA(object);
        a.start();
        ThreadB b = new ThreadB(object);
        b.start();
        ThreadC c = new ThreadC(object);
        c.start();
    }
}
