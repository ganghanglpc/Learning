package proxy;

public class ForumServiceImpl2 implements ForumService{
    @Override
    //开始对该方法进行性能监视
    public void removeTopic(int topicId) {
        //PerformanceMonitor.begin("proxy.removeTopic");
        System.out.println("模拟删除Topic记录：" + topicId);
        try{
            Thread.currentThread().sleep(20);
        }catch (InterruptedException e){
            e.printStackTrace();;
        }
        //结束监视
       // PerformanceMonitor.end();
    }

    @Override
    public void removeForum(int forumId) {
        //PerformanceMonitor.begin("proxy.removeForum");
        System.out.println("模拟删除Forum记录：" + forumId);
        try{
            Thread.currentThread().sleep(40);
        }catch (InterruptedException e){
            e.printStackTrace();;
        }
        //结束监视
        //PerformanceMonitor.end();
    }
}
