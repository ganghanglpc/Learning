/**
 * “脏读”
 * 由于get方法没有同步，出现了脏读现象。
 */
public class Run {
    public static void main(String args[]){
        try {
            PublicVar var = new PublicVar();
            ThreadA threadA = new ThreadA(var);
            threadA.start();
            Thread.sleep(200);
            var.getValue();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
