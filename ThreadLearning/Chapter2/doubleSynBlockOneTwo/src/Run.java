/**
 * 同步代码块之间的同步效果
 * 与同步方法一样，同步代码块是锁定当前对象的。
 * (1) synchronised方法：
 * 1）对其他synchronised方法或者synchronised(this)代码块呈同步效果
 * 2）同一时间只有一个线程能执行synchronised方法
 * (2) synchronised代码块：
 * 1）对其他synchronised方法或者synchronised(this)代码块呈同步效果
 * 2）同一时间只有一个线程能执行synchronise(this)d代码块
 */
public class Run {
    public static void main(String args[]){
        ObjectService service = new ObjectService();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        threadA.start();
        threadB.start();
    }
}
