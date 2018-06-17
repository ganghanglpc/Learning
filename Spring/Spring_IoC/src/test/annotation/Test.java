package test.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String args[]){
    ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation/beans.xml");
    ((ClassPathXmlApplicationContext)ctx).destroy();
    }
}
