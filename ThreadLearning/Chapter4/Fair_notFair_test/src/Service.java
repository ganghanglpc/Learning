import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service {
    private Lock lock;
    public Service(boolean isFair){
        super();
        lock = new ReentrantLock();
    }
    public void serviceMethod(){
        try{
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "获得锁定");
        }finally {
            lock.unlock();
        }
    }
}
