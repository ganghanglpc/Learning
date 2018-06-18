package test.advice;

import advice.GreetingBeforeAdvice;
import advice.NaiveWaiter;
import advice.Waiter;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class test {
    public static void main(String args[]){
        Waiter waiter = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        //Spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();

        //设置代理目标
        pf.setTarget(waiter);

        //为目标设置增强
        pf.addAdvice(advice);

        //生成代理实例
        Waiter proxy = (Waiter)pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }
}
