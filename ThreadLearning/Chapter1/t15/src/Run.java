/**
 * 先“停止”，再遇到interrupt，同样抛出异常
 * 这里的“停止”注意都不会真正停止程序，前面说过：只是打上一个状态值，想真正停止，使用异常法
 */
public class Run {
    public static void main(String args[]){

            MyThread myThread = new MyThread();
            myThread.start();
            myThread.interrupt();
            System.out.println("end");
    }
}
