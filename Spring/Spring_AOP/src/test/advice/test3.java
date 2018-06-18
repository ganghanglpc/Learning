package test.advice;

import advice.Forum;
import advice.ForumService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test3 {
    public static void main(String args[]) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("advice/beans.xml");
        ForumService service = (ForumService) ctx.getBean("forumService");
        service.updateForum(new Forum());
    }
}
