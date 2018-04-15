import java.util.ArrayList;

public class Human extends Creature {

    private String surName;

    public String getSurName() {
        return surName;
    }

    public Human(String name, String surName, int age, boolean isMale, int x, int y, ArrayList<String> logger){
        super(name, age, isMale, x, y, logger);
        this.surName = surName;
    }



    @Override
    public String toString() {
        return getName() + " " + getSurName() + " " + getAge();
    }

    @Override
    public int hashCode() {
        return getAge() + getName().hashCode() + getSurName().hashCode();
    }
}
