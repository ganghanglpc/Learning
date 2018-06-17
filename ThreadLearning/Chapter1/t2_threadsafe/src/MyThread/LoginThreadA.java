package MyThread;

import controller.LoginServlet;

public class LoginThreadA extends Thread {

    @Override
    public void run(){
        LoginServlet.doPost("a","aa");
    }
}
