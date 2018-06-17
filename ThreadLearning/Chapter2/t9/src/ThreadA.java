public class ThreadA extends Thread {
    private MyOneList list;
    public ThreadA(MyOneList list){
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
        Service service = new Service();
        service.addServiceMethod(list,"A");
    }
}
