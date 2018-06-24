package test.aspectj.basic;

import annotation.Waiter;
import aspectj.Seller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeclaredParentsTest {
    public static void main(String args[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aspectj/basic/beans.xml");

        Waiter waiter = (Waiter) ctx.getBean("waiter");

        waiter.greetTo("John");
        Seller seller = (Seller)waiter;
        seller.sell("Beer","John");
    }
}
