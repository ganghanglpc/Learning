public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 50000; i++) {
                if (this.interrupted()) {
                    System.out.println("已经是停止状态了！我要退出了！");
                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1 ));
            }
            System.out.println("我在for下面，看我会不会执行？");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
