package test.advice;

import advice.GreetingBeforeAdvice;
import advice.NaiveWaiter;
import advice.Waiter;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test2 {
    public static void main(String args[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("advice/beans.xml");
        Waiter waiter = (Waiter)ctx.getBean("waiter");
        waiter.greetTo("John");
    }
}
