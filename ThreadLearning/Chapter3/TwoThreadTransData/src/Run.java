/**
 * 用sleep与while(ture)循环实现线程间的通信
 * 但是太浪费CPU资源了。
 * 所以使用wait/notify机制
 */
public class Run {

    public static void main(String args[]){
        MyList list = new MyList();
        ThreadA a = new ThreadA(list);
        a.setName("A");
        ThreadB b = new ThreadB(list);
        b.setName("B");
        a.start();

        b.start();
    }
}
