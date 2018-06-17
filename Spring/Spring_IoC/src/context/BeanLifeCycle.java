package context;

import beanfactory.Car;
import beanfactory.MyBeanPostProcessor;
import beanfactory.MyInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * 在beanFactory中
 * 分别注册两个后处理器:MyBeanPostProcessor 和 MyInstantiationAwareBeanPostProcessor
 * (后处理器的实际调用顺序和注册顺序无关)
 */
public class BeanLifeCycle {
    public static void lifeCycleInBeanFactory(String xmlPath, String beanId) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Car car1 = (Car) applicationContext.getBean(beanId);
        car1.introduce();
        car1.setColor("红色");

        System.out.println("第二次从容器中获取car");
        Car car2 = (Car) applicationContext.getBean(beanId);

        System.out.println("car1==car2：" + (car1 == car2));

    }

    public static void main(String args[]){
        String xmlPath ="context/beans.xml";
        String beanId = "car";
        lifeCycleInBeanFactory(xmlPath,beanId);
    }
}


