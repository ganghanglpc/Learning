package attrbute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boss {
    private Car car;
    private List favorites = new ArrayList();
    private Map map = new  HashMap();

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List getFavorites() {
        return favorites;
    }

    public void setFavorites(List favorites) {
        this.favorites = favorites;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                ", favorites=" + favorites +
                ", map=" + map +
                '}';
    }
}
