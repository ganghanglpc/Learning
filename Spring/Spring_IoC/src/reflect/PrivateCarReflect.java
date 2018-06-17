package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateCarReflect {
    public static void main(String args[]) throws Throwable{
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("reflect.PrivateCar");

        PrivateCar car = (PrivateCar) clazz.newInstance();

        Field colorfield = clazz.getDeclaredField("color");

        //使域对外可见
        colorfield.setAccessible(true);
        colorfield.set(car,"红色");

        //使方法也对外暴露
        Method method = clazz.getDeclaredMethod("drive",(Class[])null);
        method.setAccessible(true);
        method.invoke(car,(Object[])null);
    }
}
