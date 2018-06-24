package advanced;

import org.aspectj.lang.annotation.Before;

/**
 * 绑定连接点的方法入参
 * NaiveWaiter(String name,int items)
 */
public class TestAspect4 {

    @Before("target(advanced.NaiveWaiter) && args(name,num,..)")
    public void bindJoinPointParams(int num,String name){

    }
}
