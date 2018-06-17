package ditype;

/**
 * 属性注入与构造函数注入
 */
public class Car {
    private String brand;
    private String corp;
    private int maxSpeed;
    private double price;

    /**
     * 当有含参构造函数时，如果使用属性注入，那么一定需要一个无参构造函数！！！
     */
    public Car(){
    }



    /**
     * 如果含有两个相同类型的参数时，如都是String 需要按照索引匹配入参
     * @param brand
     * @param corp
     * @param maxSpeed
     * @param price
     */
    public Car(String brand,String corp,int maxSpeed,double price) {
        this.brand = brand;
        this.corp = corp;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }

    /**
     * 当含有相同参数数目时，需要联合使用参数类型和索引进行匹配
     * @param brand
     * @param maxSpeed
     * @param price
     */
    public Car(String brand,int maxSpeed,double price) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }

    public Car(String brand,String corp,int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.corp = corp;
    }

    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
