public class Service {
    synchronized public static void printA(){
        try{
            System.out.println("线程名称为： " + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入了printA");
            Thread.sleep(3000);
            System.out.println("线程名称为： " + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "退出了printA");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    synchronized public static void printB(){
        try{
            System.out.println("线程名称为： " + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入了printB");
            Thread.sleep(3000);
            System.out.println("线程名称为： " + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "退出了printB");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
