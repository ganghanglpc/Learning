package aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect   //定义其为一个切面，使用注解后，该切面没有实现任何一个特殊的接口
public class PreGreetingAspect {
    @Before("execution(* greetTo(..))")      //定义切点和增强类型
    public void beforeGreeting(){           //定义增强横切逻辑
        System.out.println("How are you!");
    }
}
