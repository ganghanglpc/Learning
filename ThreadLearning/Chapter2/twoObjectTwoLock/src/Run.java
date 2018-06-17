/**
 * num变量为全局 存在线程安全问题。
 * 在非静态方法前加锁只会锁住该对象，如果有不同的对象，那么同样会出现异步效果
 * 即有两个锁（对象锁）。
 */
public class Run {

    public static void main(String args[]){
        HasSelfPrivateNum num1 = new HasSelfPrivateNum();
        HasSelfPrivateNum num2 = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(num1);
        threadA.start();
        ThreadB threadB = new ThreadB(num2);
        threadB.start();
    }
}
