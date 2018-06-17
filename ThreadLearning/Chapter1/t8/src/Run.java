public class Run {
    public static void main(String args[]){
        MyThread1 myThread1 = new MyThread1();
        System.out.println("begin =" + System.currentTimeMillis());
        myThread1.run();
        System.out.println("end =" + System.currentTimeMillis());
    }
}
