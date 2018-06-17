public class ThreadA extends Thread {
    private Object object;

    public ThreadA(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        try {
            synchronized (object){
                if(MyList.size() != 5){
                    System.out.println("wait begin"  + System.currentTimeMillis());
                    object.wait();
                    System.out.println("wait end " + System.currentTimeMillis());
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
