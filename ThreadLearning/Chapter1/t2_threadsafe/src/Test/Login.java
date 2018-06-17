package Test;

import MyThread.LoginThreadA;
import MyThread.LoginThreadB;
import controller.LoginServlet;

/**
 * 模拟登陆
 * A登录，B登录，但是因为某些原因（可能是因为网络延迟），导致数据被更改
 */
public class Login {

    public static void main(String args[]){
        LoginThreadA loginThreadA = new LoginThreadA();
        loginThreadA.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LoginThreadB loginThreadB = new LoginThreadB();
        loginThreadB.start();

    }
}
