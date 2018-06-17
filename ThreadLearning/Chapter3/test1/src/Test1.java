/**
 * 执行wait方法前，必须要确保该线程已经拿到该对象的锁。
 * 换言之，wait方法必须在同步方法或者同步代码块中执行。
 * notify()也一样。
 */
public class Test1 {
    public static void main(String args[]){
        try{
            String str = new String("");
            str.wait();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
