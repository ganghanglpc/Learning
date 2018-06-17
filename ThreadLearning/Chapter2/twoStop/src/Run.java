/**
 * 利用同步代码块实现 避免无线等待
 */
public class Run {
    public static void main(String args[]){
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.start();
        ThreadB b = new ThreadB(service);
        b.start();
    }
}
