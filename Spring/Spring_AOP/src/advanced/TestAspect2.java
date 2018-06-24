package advanced;

import org.aspectj.lang.annotation.Before;

/**
 * 对切点进行了命名，命名的规则在TestNamePointcut中
 */
public class TestAspect2 {
    @Before("TestNamePointcut.inPkgGreetTo()")
    public void pkgGreetTo(){
    }
    @Before("TestNamePointcut.inPkgGreetTo()")
    public void pkgGreetToBotNaiveWaiter(){}
}
