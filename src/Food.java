import java.util.ArrayList;
import java.util.Vector;

public class Food implements Material {
    private FoodType type;
    private int shelfLife;
    public ArrayList<String> logger;


    public FoodType getType() {
        return type;
    }

    public int getShelfLife() {
        return shelfLife;
    }


    public void effect(Creature c) {
        switch (type) {
            case MEAT:
                c.cry();
                break;
            case FISH:
                logger.add(c.getName() + " подавился костью рыбы");
                break;
            case SOUP:
                if (c.getAge() < 18) logger.add(c.getName() + " ест суп через силу, т.к. не любит его");
                else logger.add(c.getName() + " обжегся горячим супом");
                break;
            case SAUCE:
                logger.add(c.getName() + " испачкался соусом");
                break;
            case POTATO:
                logger.add(c.getName() + " очень понравился вкус кортошки");
                break;
            case CHICKEN:
                logger.add("Нежнейшее куриное мясо буквально тает во рту у " + c.getName());
                break;
        }
    }

    public String getStringFoodType() {
        String string = "Неизвестная еда";
        switch (type) {
            case MEAT:
                string = "Мясо";
                break;
            case FISH:
                string = "Рыба";
                break;
            case SOUP:
                string = "Суп";
                break;
            case SAUCE:
                string = "Соус";
                break;
            case POTATO:
                string = "Картофел";
                break;
            case CHICKEN:
                string = "Курица";
                break;
        }
        return string;
    }

    @Override
    public String getMaterialType() {
        return this.getStringFoodType();
    }

    private Food() {
    }

    ;

    public Food(FoodType type, int shelfLife, ArrayList<String> logger) {
        this.logger = logger;
        this.type = type;
        this.shelfLife = shelfLife;
    }

    @Override
    public boolean isLiquid() {
        return type.isLiquid();
    }

    public Food(FoodType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type.name();
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (this.hashCode() == obj.hashCode());
    }
}
