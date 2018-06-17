public class ThreadA extends Thread {
    ThreadB b;

    public ThreadA(ThreadB b) {
        this.b = b;
    }

    @Override
    public void run() {
        super.run();
        try{
            synchronized (b){
                b.start();
                b.join(); //释放锁
                for(int i = 0;i < Integer.MAX_VALUE; i ++){
                    String newString = new String();
                    Math.random();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
