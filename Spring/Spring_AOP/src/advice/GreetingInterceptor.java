package advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {
    @Override
    /**
     * 截获目标方法的执行，并在前后添加横切逻辑。
     */
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments(); //目标方法入参
        String clientName = (String) args[0];
        System.out.println("How are you ! Mr." + clientName + ".");

        Object obj = methodInvocation.proceed();  //通过反射机制调用目标方法。

        System.out.println("Please enjoy yourself!");
        return obj;
    }
}
