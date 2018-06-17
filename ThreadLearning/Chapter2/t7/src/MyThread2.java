public class MyThread2 extends Thread {
    private Task task;
    public MyThread2(Task task){
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }
}
