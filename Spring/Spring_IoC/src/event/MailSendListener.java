package event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 负责监听MailEvent
 */
public class MailSendListener implements ApplicationListener<MailSendEvent> {
    @Override
    public void onApplicationEvent(MailSendEvent applicationEvent) {
        MailSendEvent mse = (MailSendEvent)applicationEvent;
        System.out.println("MailSendListener:向" + mse.getTo() + "发送完一封邮件");
    }
}
