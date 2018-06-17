/**
 * join方法后面的代码提前运行。
 */
public class Run1 {
    public static void main(String args[]){
        try{
            ThreadB b = new ThreadB();
            ThreadA a = new ThreadA(b);
            a.start();
            b.start();
            b.join(2000);  //这行往往会最先运行，抢到b的锁。释放会，改方法会再次去争取b的锁，看看时间过了没。（具体实现参考P184 join方法源码)
            System.out.println("                main end " + System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
