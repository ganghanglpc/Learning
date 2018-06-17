import java.util.Random;

public class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for(int i = 0;i < 10; i ++){
            for(int j = 0; i < 5000; j ++){
                Random random = new Random();
                random.nextInt();
                addResult = addResult + 1;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("thread 2 use time =" + (endTime - beginTime));
    }
}
