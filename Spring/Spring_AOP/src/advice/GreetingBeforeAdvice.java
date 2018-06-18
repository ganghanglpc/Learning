package advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 前置增强：在服务员打招呼前先说礼貌用语
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String clientName = (String)objects[0];
        System.out.println("How are you! Mr." + clientName + ".");
    }
}
