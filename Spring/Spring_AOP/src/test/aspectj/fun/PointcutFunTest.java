package test.aspectj.fun;

import annotation.Waiter;
import aspectj.Seller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PointcutFunTest {
    public static void main(String args[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aspectj/fun/beans.xml");

        Waiter waiter1 = (Waiter) ctx.getBean("naiveWaiter");

        Waiter waiter2 = (Waiter) ctx.getBean("naughtyWaiter");

        waiter1.greetTo("John");

        waiter2.greetTo("John");
    }
}
