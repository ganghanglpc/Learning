package context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reflect.Car;

@Configuration  //表示是一个配置信息 提供类
public class Beans {
    @Bean(name = "car")
    public Car buildCar(){
        Car car = new Car();
        car.setBrand("红旗CA72");
        car.setMaxSpeed(200);
        return car;
    }
}
