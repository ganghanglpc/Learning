public class MyObject {
    //延迟加载
    private static MyObject myObject;
    private MyObject(){}
    public static MyObject getInstance(){
        if(myObject != null){
        }else {
            myObject = new MyObject();
        }
        return myObject;
    }
}
