package annotation;

public class NaiveWaiter implements Waiter {

    public void greetTo(String name) {
        System.out.println("NaiveWaiter:greet to" + name + "...");
    }


    public void serveTo(String name) {
        System.out.println("Serving " + name + "...");
    }
    public void smile(String clientName, int times) {
        System.out.println("NaiveWaiter:smile to  " + clientName + " " + times + "times...");
    }
}
