public class Run {
    public static void main(String args[]){
        ObjectService service = new ObjectService();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        threadA.setName("a");
        threadA.start();
        threadB.setName("b");
        threadB.start();
    }
}
