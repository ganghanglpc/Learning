package advanced;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 绑定代理对象
 */
@Aspect
public class TestAspect5 {
    @Before("this(waiter)")
    public void bindProxyObj(Waiter waiter){}
}
