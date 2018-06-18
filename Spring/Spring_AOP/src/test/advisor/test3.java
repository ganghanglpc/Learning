package test.advisor;

import advisor.Waiter;
import advisor.WaiterDelegate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 控制流程
 */
public class test3 {
    public static void main(String args[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("advisor/beans.xml");
        Waiter waiter =(Waiter)ctx.getBean("waiter3");
        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);
        waiter.greetTo("Peter");
        waiter.serveTo("Peter");
        wd.service("Peter");

    }
}
