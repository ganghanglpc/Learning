public class Subtract {
    private String lock;

    public Subtract(String lock) {
        this.lock = lock;
    }
    public void subtract(){
        try{
            synchronized (lock){
                if(ValueObject.list.size() == 0){
                    System.out.println("wait begin ThreadName=" + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end ThreadName=" + System.currentTimeMillis());
                }
                ValueObject.list.remove(0);
                System.out.println("list size = " + ValueObject.list.size());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
