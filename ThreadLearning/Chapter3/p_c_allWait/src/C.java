

public class C {
    private Object lock;

    public C(Object lock) {
        this.lock = lock;
    }

    public void getValue(){
        try{
            synchronized (lock){
                while(ValueObject.value.equals("")){
                    System.out.println("消费者" + Thread.currentThread().getName() + " WAITING了☆");
                    lock.wait();
                }
                System.out.println("消费者" + Thread.currentThread().getName() + " Runnable了 ");
                ValueObject.value = "";
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
