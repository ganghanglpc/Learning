package test.reflect;

import reflect.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable {
        // 获得类加载器
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        // 获取类对象
        Class clazz = loader.loadClass("reflect.Car");

        // 拿到构造器，并实例化对象
        Constructor constructor = clazz.getDeclaredConstructor((Class[])null);
        Car car = (Car)constructor.newInstance();

        //拿到方法，设置参数
        Method setBrand = clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"红旗CA72");
        Method setColor = clazz.getMethod("setColor",String.class);
        setColor.invoke(car,"黑色");
        Method setSpeed = clazz.getMethod("setMaxSpeed",int.class);
        setSpeed.invoke(car,120);

        return car;
    }

    public static void main(String args[]) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
