/**
 * 在JVM-server模式下，将不能实现停止的效果，原因是线程将在其私有堆栈中取值，而不会在公共堆栈里取值。
 */
public class Run {

    public static void main(String args[]){
        PrintString printStringService = new PrintString();
        new Thread(printStringService).start();
        System.out.println("我要停止它！ stopThread=" + Thread.currentThread().getName());
        printStringService.setContinuePrint(false);
    }
}
