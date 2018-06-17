/**
 * 同步不能继承
 */
public class Run {
    public static void main(String args[]){
        Sub sub = new Sub();
        MyThreadA threadA = new MyThreadA(sub);
        MyThreadB threadB = new MyThreadB(sub);
        threadA.start();
        threadB.start();
    }
}
