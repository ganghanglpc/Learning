public class Run {
    public static void main(String args[]){
        Task task = new Task();
        MyThread1 myThread1 = new MyThread1(task);
        MyThread2 myThread2 = new MyThread2(task);
        myThread1.start();
        myThread2.start();
    }
}
