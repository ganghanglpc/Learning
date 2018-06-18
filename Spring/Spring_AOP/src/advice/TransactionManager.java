package advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class TransactionManager implements ThrowsAdvice {
    //定义增强逻辑

    /**
     * 方法名必须固定不变，方法前三个入参可选：即要么一起提供，要么都不提供
     * @param method
     * @param args
     * @param target
     * @param ex
     * @throws Throwable
     */
    public void afteThrowing(Method method, Object[] args,Object target,Exception ex)throws Throwable{
        System.out.println("----------");
        System.out.println("method:" + method.getName());
        System.out.println("抛出异常:" + ex.getMessage());
        System.out.println("成功回滚事务");
    }
}
