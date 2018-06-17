public class Countoperate extends Thread {

    public Countoperate(){
        System.out.println("Countoperate--begin");
        System.out.println("Thread.currentThread.getName=" + Thread.currentThread().getName());
        System.out.println("this.getName=" + this.getName());
        System.out.println("Countoperate--end");
    }
    @Override
    public void run() {
        super.run();
        System.out.println("run--begin");
        System.out.println("run" + Thread.currentThread().getName());
        System.out.println("run" + this.getName());
        System.out.println("run--end");
    }
}
