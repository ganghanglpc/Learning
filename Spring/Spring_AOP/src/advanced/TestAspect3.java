package advanced;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * 使用JointPoint访问连接点信息
 */
public class TestAspect3 {
    @Around("target(advanced.NaiveWaiter)")
    public void jointPointAccess(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("----joinPointAccess----");

        System.out.println("args[0]" + pjp.getArgs()[0]);
        System.out.println("signature" + pjp.getClass().getName());
        pjp.proceed();

        System.out.println("----joinPointAccess----");
    }
}
