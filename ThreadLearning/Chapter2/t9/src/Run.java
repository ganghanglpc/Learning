/**
 * 线程间是异步进行的，在进行分支判断的话，有可能出现非线程安全问题。
 */
public class Run {
    public static void main(String args[]) throws InterruptedException {
        MyOneList list = new MyOneList();
        ThreadA threadA = new ThreadA(list);
        ThreadB threadb = new ThreadB(list);
        threadA.setName("a");
        threadb.setName("b");
        threadA.start();
        threadb.start();
        Thread.sleep(6000);
        System.out.println("listSize=" + list.getSize());
    }
}
