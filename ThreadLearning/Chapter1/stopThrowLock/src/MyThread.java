public class MyThread extends Thread {
    private SynchronisedObject synchronisedObject;

    public MyThread(SynchronisedObject synchronisedObject){
        this.synchronisedObject = synchronisedObject;
    }

    @Override
    public void run() {
        super.run();
        synchronisedObject.printString("b","bb");
    }
}
