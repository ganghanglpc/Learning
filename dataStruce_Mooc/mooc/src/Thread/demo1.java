package Thread;

public class demo1 {

    public static void main(String args[]) throws InterruptedException {
        MyObject myObject = new MyObject();
        Thread myThread1 = new MyThread1(myObject);
        Thread myThread2 = new MyThread2(myObject);
        myThread1.start();
        //Thread.sleep(10000);
        myObject.setAagain(10);
        System.out.println(Thread.currentThread().getName() + " " + myObject.getA());
    }
}

class MyThread1 extends Thread{
    private MyObject myObject;
    public MyThread1(MyObject myObject){
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
        myObject.setA(1);
    }
}


class MyThread2 extends Thread{
    private MyObject myObject;
    public MyThread2(MyObject myObject){
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
        myObject.setAagain(3);
    }
}

class MyObject{
    private int a;
    public void setA(int a){
            this.a = a;
            System.out.println(Thread.currentThread().getName() + " " + a);

    }
    public void setAagain(int a){
        try {
            this.a = a;
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int getA() {
        return this.a;
    }
}
