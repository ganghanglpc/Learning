package advanced;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 匿名切点
 */
@Aspect
public class TestAspect {
    @After("execution(* greetTo(..))")
    public void greeToFun(){
        System.out.println("--greeToFun() executed");
    }
    @Before("execution(* serveTo(..))")
    public void notServeInNaiveWaiter(){
        System.out.println("--notServeInNaiveWaiter() executed");
    }
    @AfterReturning("execution(* serveTo(..))")
    public void waiterOrSeller(){
        System.out.println("--waiterOrSeller() executed");
    }
}
