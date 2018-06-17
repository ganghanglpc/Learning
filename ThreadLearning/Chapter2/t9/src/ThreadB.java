public class ThreadB extends Thread {
    private MyOneList list;
    public ThreadB(MyOneList list){
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
        Service service = new Service();
        service.addServiceMethod(list,"B");
    }
}
