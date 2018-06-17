package beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean {
    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car(){
        System.out.println("调用Car()构造函数");
    }

    public void setBrand(String brand){
        System.out.println("调用setBrand()设置属性");
        this.brand = brand;
    }

    public void introduce(){
        System.out.print("brand : " + brand + " color : " + color + " maxSpeed : " + maxSpeed);
    }

    //BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBrandFactory()。");
        this.beanFactory = beanFactory;
    }
    //BeanNameAware接口方法
    @Override
    public void setBeanName(String s) {
        System.out.println("调用BeanNameAware.setBrandName()。");
        this.beanName = beanName;
    }
    //InitializingBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destroy()。");
    }
    //DisposableBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()。");
    }
    //<bean>的init-method属性所指定的初始化方法
    public void myInit(){
        System.out.println("调用init-method所指定的myInit(),将maxSpeed设置成240。");
        this.maxSpeed = 240;
    }
    //<bean>的destroy-method属性所指定的销毁方法
    public void myDestroy(){
        System.out.println("调用destroy-method所指定的myDestroy().");
    }

    public String getBrand() {
        return brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
