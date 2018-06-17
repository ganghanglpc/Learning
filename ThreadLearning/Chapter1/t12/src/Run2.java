/**
 * 第二次清除标记
 *
 */
public class Run2 {
    public static void main(String agrs[]){
        Thread.currentThread().interrupt();
        System.out.println("是否停止1=" + Thread.interrupted());
        System.out.println("是否停止2=" + Thread.interrupted());
    }
}
