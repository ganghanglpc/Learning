public class ThreadB extends Thread {
    private Object object;

    public ThreadB(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        try {
            synchronized (object){
                for(int i = 0; i < 10; i ++){
                    MyList.add();
                    if(MyList.size() == 5){
                        object.notify();
                        System.out.println("已发出通知");
                    }
                    System.out.println("添加了" +  (i + 1) + "个元素");
                    Thread.sleep(1000);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
