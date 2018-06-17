/**
 * suspend造成数据不同步
 */
public class Run {

    public static void main(String agrs[]){
        try{
            final MyObject object = new MyObject();
            Thread thread1 = new Thread() {
                public void run() {
                    object.setVaule("a", "aa");
                }
            };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);
            Thread thread2 = new Thread(){
                public void run(){
                    object.print();
                }
            };
            thread2.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
