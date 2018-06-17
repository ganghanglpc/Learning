/**
 * 枚举类数据类型实现单例，但是将枚举类进行了暴露，违反了“职责单一”原则。
 * 这个例子将它补充完善
 * 至此，单例模式告一段落。
 */
public class Run {
    public static void main(String args[]) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}
