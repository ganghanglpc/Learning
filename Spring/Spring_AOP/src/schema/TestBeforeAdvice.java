package schema;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class TestBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("---TestBeforeAdvice---");
        System.out.println("clientName:" + objects[0]);
        System.out.println("---TestBeforeAdvice---");
    }
}
