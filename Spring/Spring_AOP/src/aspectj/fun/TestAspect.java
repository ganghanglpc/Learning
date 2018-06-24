package aspectj.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect {
    /**
     * `@annotation()`
     * 针对目标类而言,而非针对运行时的引用类型而言
     */
    @AfterReturning("@annotation(aspectj.annotation.NeedTest)")public void needTest() {     System.out.println("needTest() executed");
   }

    /**
     * execution()
     * - 通过方法签名定义切点
     * - 通过类定义切点
     * - 通过类包定义切点
     * - 通过方法入参点定义切点
     */

    //第一个*代表返回类型 第二个*代表方法名 .代表任意入参的方法
//    @Before("execution(public * *(..))")
//    public void allPublicFunction() {
//        System.out.println("allPublicFunction() executed!");
//    }

//    @AfterReturning("execution(* *To(..))")
//    public void allToFunction() {
//        System.out.println("allToFunction() executed!");
//    }

//    @Before("execution(* aspectj.Waiter.*(..))")
//    public void allWaiterFunction() {
//        System.out.println("allWaiterFunction() executed!");
//    }

//    @Before("execution(* aspectj.Waiter+.*(..))")
//    public void allChildClassFunction() {
//        System.out.println("allChildClassFunction() executed!");
//    }

//    //@Before("execution(* joke(Object,int)))")
//    @Before("args(Object,*)")
//    public void jokeFunction() {
//        System.out.println("jokeFunction() executed!");
//    }

    /**
     * args()和@args()
     * - args(): 目标类方法入参对象是指定类(包含子类)时,切点匹配
     * - @args(): 注意"注解点"和"入参类型点"的相对位置
     */
//    @AfterReturning("args(String)")
//    public void argsTest() {
//        System.out.println("argsTest() executed!");
//    }

//    @AfterReturning("@args(aspectj.Monitorable)")
//    public void atArgsTest() {
//        System.out.println("atArgsTest() executed!");
//    }

    /**
     * within()
     * 指定连接点的最小范围只能是类
     */
//    @Before("within(aspectj.Waiter)")
//    public void withinTest(){
//    	System.out.println("withinTest() executed!");
//    }

//    @Before("@within(aspectj.Monitorable)")
//    public void atWithinTest() {
//        System.out.println("atWithinTest() executed!");
//    }

    /**
     * target()和this()
     * - target(): 判断目标类是否按照类型匹配指定类
     * - this(): 判断代理类是否按照类型匹配指定类
     */
//    @AfterReturning("target(aspectj.Seller)")
//    public void targetTest(){
//        System.out.println("targetTest() executed!");
//    }
//    @AfterReturning("this(aspectj.Seller)")
//    public void thisTest() {
//        System.out.println("thisTest() executed!");
//    }

}

