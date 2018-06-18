package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler{
    private Object target;//目标业务类

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
        Object obj = method.invoke(target,args);   //通过反射调用目标类的业务方法
        PerformanceMonitor.end();
        return obj;
    }
}
