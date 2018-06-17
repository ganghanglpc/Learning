package context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import reflect.Car;

public class AnnotationApplication {
    public static void main(String args[]){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);

        Car car = ctx.getBean("car",Car.class);
        car.introduce();
    }
}
