/**
 * 对第一个项目：两个线程间通信的改进。不再使用while()循环和sleep，转而使用wait/notify
 * 可以看到notify之后，要等notify所在线程B的所有代码执行完毕后，线程B才会释放锁，线程A才能拿到锁。
 * 进入wait，线程进入了阻塞状态(Blocked))
 * notify()仅通知一个线程
 * notifyAll()通知所有线程。
 * sleep wait suspend
 */
public class Run {
    public static void main(String args[]){
        try{
            Object object = new Object();
            ThreadA a = new ThreadA(object);
            a.start();
            Thread.sleep(50);
            ThreadB b = new ThreadB(object);
            b.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
