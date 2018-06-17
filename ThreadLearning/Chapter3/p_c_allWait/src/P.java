

public class P {
    private Object lock;

    public P(Object lock) {
        this.lock = lock;
    }

    public void setValue(){
        try{
            synchronized (lock){
                while (!ValueObject.value.equals("")){
                    System.out.println("生产者" + Thread.currentThread().getName() + " WAITING了 ☆");
                    lock.wait();
                }
                System.out.println("生产者" + Thread.currentThread().getName() + " Runnable了 ");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                ValueObject.value = value;
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
