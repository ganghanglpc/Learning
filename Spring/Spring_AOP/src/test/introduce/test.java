package test.introduce;



import introduce.ForumService;
import introduce.Monitorable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String args[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("introduce/beans.xml");
        ForumService service = (ForumService) ctx.getBean("forumService");
        service.removeForum(10);
        service.removeTopic(1022);  //默认情况未开启性能监视

        Monitorable monitorable = (Monitorable)service;   //开启性能监视
        monitorable.setMonitorActive(true);

        service.removeForum(10);
        service.removeTopic(1022);
    }
}
