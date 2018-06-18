package test.advisor;

import advisor.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 动态切面
 */
public class test2 {
    public static void main(String args[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("advisor/beans.xml");
        Waiter waiter =(Waiter)ctx.getBean("waiter2");
        waiter.greetTo("Peter");
        waiter.serveTo("Peter");
        waiter.greetTo("John");
        waiter.serveTo("John");

    }
}
