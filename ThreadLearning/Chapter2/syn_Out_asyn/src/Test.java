public class Test {
    public static void main(String args[]){
        MyList list = new MyList();
        ThreadA threadA = new ThreadA(list);
        Threadb threadb = new Threadb(list);
        threadA.setName("a");
        threadb.setName("b");
        threadA.start();
        threadb.start();
    }
}
