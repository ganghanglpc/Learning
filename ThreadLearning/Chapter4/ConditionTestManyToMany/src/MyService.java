import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Boolean hasValue = false;
    public void set(){
        try{
            lock.lock();
            while (hasValue == true){  //使用while循环
                condition.await();
            }
            System.out.println("有可能_______________连续");
            hasValue = true;
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void get(){
        try{
            lock.lock();
            if(hasValue == false){
                condition.await();
            }
            System.out.println("有可能☆☆☆☆☆☆☆☆☆☆连续");
            hasValue = false;
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
