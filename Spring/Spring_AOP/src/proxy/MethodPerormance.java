package proxy;

public class MethodPerormance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerormance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();   //目标类方法开始执行点的系统时间。（连接点）
    }

    public void printPerformance(){
        end = System.currentTimeMillis();
        long elapse = end - begin;

        System.out.println(serviceMethod + "花费" + elapse + "毫秒");
    }
}
