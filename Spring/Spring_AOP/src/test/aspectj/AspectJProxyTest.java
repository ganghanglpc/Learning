package test.aspectj;

import annotation.NaiveWaiter;
import annotation.Waiter;
import aspectj.PreGreetingAspect;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class AspectJProxyTest {
    public static void main(String args[]){
        Waiter target = new NaiveWaiter();

        AspectJProxyFactory factory = new AspectJProxyFactory();

        factory.setTarget(target);

        factory.addAspect(PreGreetingAspect.class);

        Waiter proxy = factory.getProxy();

        proxy.greetTo("John");
        proxy.serveTo("John");
    }
}
