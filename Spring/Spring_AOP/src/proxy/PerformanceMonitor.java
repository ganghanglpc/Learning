package proxy;

public class PerformanceMonitor {
    //
    private static ThreadLocal<MethodPerormance> perormanceThreadLocal = new ThreadLocal<>();

    //启动对某一目标方法的性能监视
    public static void begin(String method){
        System.out.println("begin monitor....");
        MethodPerormance mp = new MethodPerormance(method);
        perormanceThreadLocal.set(mp);
    }

    public static void end(){
        System.out.println("end monitor....");
        MethodPerormance mp = perormanceThreadLocal.get();
        //打印出性能监视结果信息。
        mp.printPerformance();
    }
}
