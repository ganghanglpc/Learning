public class Service {
    Object object1 = new Object();
    public void methodA(){
        System.out.println("methodA begin");
        synchronized (object1) {
            boolean isContinueRun = true;
            while (isContinueRun) {
            }
            System.out.println("methodA end");
        }
    }
    Object object2 = new Object();
    public void methodB(){
        synchronized (object2) {
            System.out.println("methodB begin");
            System.out.println("methodB end");
        }
    }
}
