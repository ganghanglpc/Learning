package test.schema;

import annotation.NaiveWaiter;
import annotation.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String args[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("schema/beans.xml");
        Waiter waiter = (Waiter)ctx.getBean("naiveWaiter");
        ((NaiveWaiter)waiter).smile("John",2);
    }
}
