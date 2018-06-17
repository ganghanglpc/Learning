package reflect;

public class PrivateCar {
    //private成员变量，传统方式只能在本类中访问
    private String color;
    //protected方法，只有子类和本包中才能访问
    protected void drive(){
        System.out.println("drive private car ! the color is:" + color);
    }
}
