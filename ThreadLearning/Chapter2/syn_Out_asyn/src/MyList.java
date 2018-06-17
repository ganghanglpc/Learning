import java.util.ArrayList;
import java.util.List;

public class MyList {
    private List list = new ArrayList();
    synchronized public void add(String username){
        System.out.println("ThreadName=" + Thread.currentThread().getName() + "执行了add方法");
        list.add(username);
        System.out.println("ThreadName=" + Thread.currentThread().getName() + "退出了add方法");
    }
    synchronized public int getSize(){
        System.out.println("ThreadName=" + Thread.currentThread().getName() + "执行了getSize方法");
        System.out.println("ThreadName=" + Thread.currentThread().getName() + "退出了getSize方法");
        return list.size();
    }
}
