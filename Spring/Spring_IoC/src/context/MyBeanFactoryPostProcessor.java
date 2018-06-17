package context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 在ApplicationContext中，只需在配置文件中配置<bean>定义 工厂后处理器 和 bean后处理器，它们就会按预期方式运行
 * 我们来看一个对配置文件中的car的brand属性进行“偷梁换柱”
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("car");

        bd.getPropertyValues().addPropertyValue("brand","奇瑞QQ");
        System.out.println("调用BeanFactoryPostProcessor.postProcessBean Factory()!");
    }
}
