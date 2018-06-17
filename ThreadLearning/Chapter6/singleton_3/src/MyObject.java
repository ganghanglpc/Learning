public class MyObject {
    //延迟加载
    private static MyObject myObject;
    private MyObject(){}
    public static MyObject getInstance(){
        try {
            if (myObject != null) {
            } else {
                //模拟创建对象前的一些代码
                Thread.sleep(3000);
                //使用同步代码块 虽然部分代码上锁 但还是有非线程安全问题
                synchronized (MyObject.class) {
                    myObject = new MyObject();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return myObject;
    }
}
