package test.ditype;

import ditype.Boss;
import ditype.Car;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ditypeTest {

    @Test
    public void listCars() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ditype/beans.xml");
        int count = 7;
        Car[] cars = new Car[count];
        for (int i = 0; i < 6; i++) {
            cars[i] = (Car) ctx.getBean("car" + (i > 0 ? i : ""));
            System.out.println(cars[i]);
        }
    }

    @Test
    public void listBosses() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ditype/beans.xml");
        System.out.println((Boss)ctx.getBean("boss"));
    }
}