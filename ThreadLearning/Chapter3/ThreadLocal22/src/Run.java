/**
 * 改变初试默认值
 * 使用InheritableThreadLocal类可以让   子线程从父线程取得值
 */
public class Run {
    public static ThreadLocal tl = new ThreadLocalExt();
    public static void main(String args[]){
        if(tl.get() == null){
            System.out.println("初始化值失败");
            tl.set("lpccc");
        }
        System.out.println(tl.get());
        System.out.println(tl.get());
    }

}
