public class MyThread1 extends Thread {
    private Task task;
    public MyThread1(Task task){
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        Commonutils.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask();
        Commonutils.beginTime1 = System.currentTimeMillis();
    }
}
