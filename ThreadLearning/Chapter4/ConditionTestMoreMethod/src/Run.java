/**
 * 同步再次测验效果。
 */
public class Run {
    public static void main(String args[]){
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        ThreadAA aa = new ThreadAA(service);
        aa.setName("AA");
        aa.start();
        ThreadBB bb = new ThreadBB(service);
        bb.setName("BB");
        bb.start();
    }

}
