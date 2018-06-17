package controller;

/**
 * 模拟登陆
 */
public class LoginServlet{
    private static String usernameRef;
    private static String passwordRef;

    /*线程非安全

    public static void doPost(String username,String password){
        try {
            usernameRef = username;
            if (username.equals("a"))
                Thread.sleep(5000);
            passwordRef = password;
            System.out.println(usernameRef + "" + passwordRef);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    */

    /* 线程安全 */
    synchronized public static void doPost(String username,String password){
        try {
            usernameRef = username;
            if (username.equals("a"))
                Thread.sleep(5000);
            passwordRef = password;
            System.out.println(usernameRef + "" + passwordRef);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
