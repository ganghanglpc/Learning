public class Run  {
    public static void main(String args[]){
        System.out.println("main thread begin priority =" + Thread.currentThread().getPriority());
        System.out.println("main thread end priority =" + Thread.currentThread().getPriority());
        MyThread1 thread1 = new MyThread1();
        thread1.start();
    }
}
