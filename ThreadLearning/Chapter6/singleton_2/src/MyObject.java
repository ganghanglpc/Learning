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
                myObject = new MyObject();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return myObject;
    }
}
