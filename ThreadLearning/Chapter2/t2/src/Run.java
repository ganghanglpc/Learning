/**
 * num变量为全局 存在线程安全问题。
 */
public class Run {

    public static void main(String args[]){
        HasSelfPrivateNum num = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(num);
        threadA.start();
        ThreadB threadB = new ThreadB(num);
        threadB.start();
    }
}
