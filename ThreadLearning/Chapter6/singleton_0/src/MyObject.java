public class MyObject {
    //饿汉模式  立即加载  static
    private static MyObject myObject = new MyObject();
    private MyObject(){}
    public static MyObject getInstance(){
        //此代码版本为立即加载
        //此版本代码的缺点是不能有其他实例变量
        //因为getInstance方法没有同步
        //所以可能出现非线程安全问题
        return myObject;
    }
}
