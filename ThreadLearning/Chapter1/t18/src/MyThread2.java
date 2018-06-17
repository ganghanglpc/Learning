/**
 * 线程优先级具有继承性，这里指的是：
 * A启动B 则B与A有相同的优先级。
 */

public class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread2 run priority=" + this.getPriority());
    }
}
