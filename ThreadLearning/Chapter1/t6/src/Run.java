/**
 * currentThread 获取“被哪个线程调用”的信息
 * this 自己这个线程（本身）
 * 注意this与currentThread 的区别
 * 当线程作为参数传入线程的时候，尤其小心
 * 如果A作为B的参数传入，运行B 那么this会显示为A，currentThread 显示为B，即B在调用A。
 */
public class Run {
    public static void main(String args[]){
        Countoperate c = new Countoperate();
        Thread t1 = new Thread(c);
        t1.setName("A");
        t1.start();
        c.start();
    }
}
