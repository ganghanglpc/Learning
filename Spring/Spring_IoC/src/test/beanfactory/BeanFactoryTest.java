package test.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import reflect.Car;

/**
 * XmlBeanFactory通过Resource装载Spring配置信息 并且 启动IoC容器。
 * 通过BeanFactory启动IoC容器时，不会初始化配置文件中定义的Bean
 * 初始化发生在第一个调用时
 */
public class BeanFactoryTest {
    public static void main(String args[]) throws Throwable{
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:beanfactory/beans.xml");
        BeanFactory bf = new XmlBeanFactory(res);
        System.out.println("init BeanFactory");

        Car car = bf.getBean("car",Car.class);
        car.introduce();
        System.out.println("car bean is ready for use!");
    }
}
