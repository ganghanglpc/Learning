public class MyObject {
    //静态代码块
    private static MyObject myObject = null;
    private MyObject(){
    }

    static {
        myObject = new MyObject();
    }
    public static MyObject getInstance(){
        return myObject;
    }
}
