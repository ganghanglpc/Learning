package test.editor;

import editor.Boss;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 可能hi因为JDK和Spring版本的原因，此测试并不能通过。
 */
public class Test {
    public static void main(String args[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/editor/beans.xml");
        Boss boss = (Boss)ctx.getBean("boss");
        System.out.println(boss);
    }
}
