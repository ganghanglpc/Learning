package introduce;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import proxy.PerformanceMonitor;

/**
 * 引介增强：不是在目标方法周围引入增强，而是引入新的方法。
 */
public class ControllerPerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {
    private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();
    public void setMonitorActive(boolean active){
        MonitorStatusMap.set(active);
    }
    //拦截方法
    public Object invoke(MethodInvocation mi) throws Throwable{
        Object obj = null;

        if(MonitorStatusMap.get() != null && MonitorStatusMap.get()){
            PerformanceMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName());
            obj = super.invoke(mi);
            PerformanceMonitor.end();
        }else {
            obj = super.invoke(mi);
        }
        return obj;
    }
}
