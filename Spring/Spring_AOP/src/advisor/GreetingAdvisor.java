package advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * 静态普通方法匹配切面
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    @Override
    /**
     * 切点方法匹配规则：方法名为greetTo
     */
    public boolean matches(Method method, Class<?> aClass) {
        return "greetTo".equals(method.getName());
    }

    /**
     * 切点类 匹配规则：Waiter或者Waiter的子类
     * @return
     */
    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }
}
