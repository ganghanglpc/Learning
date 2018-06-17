package test.attrute;

import attrbute.Boss;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试注入参数
 */
public class AttributeTest {

    @Test
    public void referParent() {
        //父容器
        ClassPathXmlApplicationContext pFactory = new ClassPathXmlApplicationContext(new String[] {"attrbute/beans-1.xml"});
        //指定pFacroty为该容器的父容器
        ApplicationContext factory = new ClassPathXmlApplicationContext(
                new String[] {"attrbute/beans-2.xml"},
                pFactory
        );
        Boss boss = (Boss) factory.getBean("boss");
        System.out.println(boss.getCar().toString());
    }

    @Test
    public void innerBean() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("attrbute/beans-1.xml");
        Boss boss = (Boss) ctx.getBean("boss3");
        System.out.println(boss);
    }
}
