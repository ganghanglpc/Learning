public class Test {
    public static void main(String args[]){
        MyThread threadTest = new MyThread();
        threadTest.start();
        System.out.println("我想在threadTest对象执行完毕之后我再执行");
        System.out.println("但是sleep中的值应该是多少呢？");
        System.out.println("答案是：不能确定~");
    }
}
