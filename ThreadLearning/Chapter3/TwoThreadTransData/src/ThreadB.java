public class ThreadB extends Thread{
    private MyList list;

    public ThreadB(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try{
            while (true){
                if(list.size() > 5){
                    System.out.println("我没跑吗？？");
                    System.out.println(">5了，线程b要退出了！");
                    throw new InterruptedException();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
