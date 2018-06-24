package advanced;

import advice.Waiter;

public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println("greet to" + name + "...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("Serving " + name + "...");
    }
}
