/**
 * synchronised(非this 对象x)拿到的是与this不同的对象监视器，可以与this产生异步效果。
 */
public class Run {

    public static void main(String args[]){
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        threadA.setName("a");
        threadB.setName("b");
        threadA.start();
        threadB.start();
    }
}
