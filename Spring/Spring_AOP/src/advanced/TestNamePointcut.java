package advanced;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 对切点进行命名
 */
public class TestNamePointcut {
    /**
     * 修饰符 private 只能在本类中使用该切点名
     */
    @Pointcut("within(advanced.*)")
    private void inPackage(){
    }
    /**
     * 修饰符 public 只能在本类及其子类中使用该切点名
     */
    @Pointcut("execution(* greetTo(..))")
    protected void greetTo(){}
    /**
     * 修饰符 public 公用切点名
     */
    @Pointcut("inPackage() and greetTo()")
    public void inPkgGreetTo(){}
}
