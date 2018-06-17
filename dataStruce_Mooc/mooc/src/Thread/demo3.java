package Thread;

public class demo3 {

    public static void main(String args[]){
        SyObject syObject = new SyObject();
        SyThread syThread = new SyThread(syObject);
        SyThread2 syThread2 = new SyThread2(syObject);
        syThread.start();
        syThread2.start();
    }
}

class SyThread extends Thread{
    private SyObject syObject;
    public SyThread(SyObject syObject){
        this.syObject = syObject;
    }
    @Override
    public void run(){
        super.run();
        syObject.setUsername("John");
        try {
            Thread.sleep(2000);
            System.out.println(syObject.getUsername());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SyThread2 extends Thread{
    private SyObject syObject;
    public SyThread2(SyObject syObject){
        this.syObject = syObject;
    }
    @Override
    public void run(){
        super.run();
        syObject.setUsername("Tom");
    }
}

class SyObject{
    private String username;
    private String passwword;

    public String getPasswword() {
        return passwword;
    }

    public void setPasswword(String passwword) {
        this.passwword = passwword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
