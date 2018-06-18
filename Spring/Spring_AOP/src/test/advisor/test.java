package test.advisor;

import advisor.Seller;
import advisor.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 静态方法切面
 */
public class test {
    public static void main(String args[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("advisor/beans.xml");
        Waiter waiter =(Waiter)ctx.getBean("waiter");
        Seller seller =(Seller)ctx.getBean("seller");
        waiter.greetTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");
    }
}
