package MyThread;

import controller.LoginServlet;

public class LoginThreadB extends Thread {
    @Override
    public void run(){
        LoginServlet.doPost("b","bb");
    }
}
