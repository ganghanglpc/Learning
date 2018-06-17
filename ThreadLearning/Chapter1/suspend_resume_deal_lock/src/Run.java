/**
 * suspend造成的独占
 */
public class Run {
    public static void main(String agrs[]){
        try{
            final SynchronisedObject object = new SynchronisedObject();
            Thread thread = new Thread(){
                @Override
                public void run() {
                    super.run();
                    object.printString();
                }
            };
            thread.setName("a");
            thread.start();
            Thread.sleep(1000);
            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    System.out.println("thread1启动了，但是进入不了printString方法！只打印一个begin");
                    System.out.println("因为printString方法被A线程锁定并且暂停了！");
                    object.printString();
                }
            };
            thread1.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
