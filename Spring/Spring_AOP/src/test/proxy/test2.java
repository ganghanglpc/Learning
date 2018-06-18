package test.proxy;

import proxy.ForumService;
import proxy.ForumServiceImpl;
import proxy.PerformanceHandler;

import java.lang.reflect.Proxy;

public class test2 {
    public static void main(String args[]){
        ForumService target = new ForumServiceImpl();  //☆☆☆希望被代理的目标业务类☆☆☆

        PerformanceHandler handler = new PerformanceHandler(target); //☆☆☆将目标业务类和 横切代码编织到一起☆☆☆

        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);

        proxy.removeForum(10);
        proxy.removeTopic(1012);  //调用代理实例
    }
}
