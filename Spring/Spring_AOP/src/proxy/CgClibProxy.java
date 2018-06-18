package proxy;


import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 采用CGLib,代理创建器
 */
import java.lang.reflect.Method;

public class CgClibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz); //设置需要创建子类的父类
        enhancer.setCallback(this);
        return enhancer.create(); //通过字节码技术动态创建子类实例
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable{
        PerformanceMonitor.begin(obj.getClass().getName() + "." + method.getName());
        Object result = proxy.invokeSuper(obj,args);   //通过代理调用父类方法；
        PerformanceMonitor.end();
        return  result;
    }
}
