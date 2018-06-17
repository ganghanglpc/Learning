/**
 * synchronised(非this 对象x)拿到的是与this不同的对象监视器，可以与this或者同步方法产生异步效果，这样的话混合使用容易出现脏读问题。
 */
public class Run {

    public static void main(String args[]){
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        threadA.setName("a");
        threadB.setName("b");
        threadA.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
    }
}
