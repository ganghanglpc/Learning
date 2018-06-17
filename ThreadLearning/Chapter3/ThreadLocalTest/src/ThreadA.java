public class ThreadA extends Thread {
    @Override
    public void run() {
        try{
            for(int i = 0; i < 100;i ++){
                Tools.tl.set("ThreadA" + (i + 1));
                System.out.println("ThreadA get Value=" + Tools.tl.get());
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
