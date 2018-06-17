package Thread;

/**
 * 数据共享与数据不共享的情况
 */
public class demo2 {

    public static void main(String agrs[]){
        /**
         * 数据不共享
        Thread02 thread01 = new Thread02();
        Thread02 thread011 = new Thread02();
        Thread02 thread012 = new Thread02();
        thread01.start();
        thread011.start();
        thread012.start();
        **/

        /* 数据共享 */
        Thread02 thread02 = new Thread02();
        Thread thread021 = new Thread(thread02);
        Thread thread = new Thread(thread02);
        thread021.start();
        thread.start();
    }
}

class Thread01 extends Thread{
    private int count = 5;

    @Override
    public void run() {
        super.run();
        while(count > 0){
            count--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(count);
        }
    }
}

class Thread02 extends Thread{
    private int count = 5;
    @Override
    public void run(){
        super.run();
        count--;
        System.out.println(count);

    }
}
