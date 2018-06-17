/**
 * 当wait的等待条件发生了改变时，可能会造成异常，所以有if判断的时候，多会改为while判断。
 */
public class Run {
    public static void main(String args[]) throws InterruptedException {
        String object = new String();
        Add add = new Add(object);
        Subtract subtract = new Subtract(object);
        ThreadA a = new ThreadA(add);
        ThreadB b = new ThreadB(subtract);
        ThreadC c = new ThreadC(subtract);
        b.start();
        c.start();
        Thread.sleep(1000);
        a.start();
    }
}
