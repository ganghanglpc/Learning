package test.proxy;

import proxy.CgClibProxy;
import proxy.ForumServiceImpl2;


public class testofCglib {
    public static void main(String args[]){
        CgClibProxy proxy = new CgClibProxy();
        ForumServiceImpl2 forumService = (ForumServiceImpl2) proxy.getProxy(ForumServiceImpl2.class);  //通过动态生成子类的方式创建代理类
        forumService.removeForum(20);
        forumService.removeTopic(1024);
    }
}
