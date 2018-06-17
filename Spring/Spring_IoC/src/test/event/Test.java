package test.event;

import event.MailSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String args[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("event/beans.xml");
        MailSender mailSender = (MailSender) ctx.getBean("mailsender");
        mailSender.sendMail("lpc");
    }
}
