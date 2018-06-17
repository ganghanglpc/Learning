package event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 要拥有发布事件的能力，就必须实现ApplicationContextAwarej接口
 */
public class MailSender implements ApplicationContextAware {
    private ApplicationContext ctx;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
    public void sendMail(String to){
        System.out.println("MailSender：模拟发送邮件");
        MailSendEvent mse = new MailSendEvent(this.ctx,to);
        //想容器的所有事情监听器发送事件。
        ctx.publishEvent(mse);
    }
}
