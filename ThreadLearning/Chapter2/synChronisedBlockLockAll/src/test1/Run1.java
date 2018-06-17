package test1;

public class Run1 {
    public static void main(String args[]){
        MyObject object1 = new MyObject();
        MyObject object2 = new MyObject();
        Service service = new Service();
        ThreadA threadA = new ThreadA(service,object1);
        ThreadB threadB = new ThreadB(service,object2);
        threadA.setName("a");
        threadB.setName("b");
        threadA.start();
        threadB.start();
    }
}
