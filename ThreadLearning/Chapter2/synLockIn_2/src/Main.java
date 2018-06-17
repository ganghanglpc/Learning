public class Main {
    public int i = 10;
    synchronized public void operateMainMethod(){
        try{
            i--;
            System.out.println("main print i=" + i);
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
