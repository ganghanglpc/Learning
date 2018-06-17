/**
 * join方法，等当前线程执行完毕之后，主线程再执行。
 * join内部使用wait方法实现，synchronised使用对象的监视器。
 */
public class Test {
    public static void main(String args[]){
        try {
            MyThread threadTest = new MyThread();
            threadTest.start();
            threadTest.join();
            System.out.println("我想在threadTest对象执行完毕之后我再执行");
            System.out.println("但是sleep中的值应该是多少呢？");
            System.out.println("答案是：不能确定~");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
