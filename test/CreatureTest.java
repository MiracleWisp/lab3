import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CreatureTest {
    private ArrayList<String> logger = new ArrayList<>();
    private Food fish = new Food(FoodType.FISH, 7, logger);
    private Plate plate = new Plate(7, 7, logger);
    private Creature male = new Carlson("Цопа", 37, 7, 5, logger);
    private Creature female = new Human("Ксения", "Олеговна", 19, false, 20, 20, logger);
    private Creature young = new Human("Мироша", "Федоров", 17, true, -4, -44, logger);


    @Before
    public void cleanLog() {
        logger.clear();
    }

    @Test
    public void eatDoesNotExist() {
        male.eat(fish, 7, plate);
        assertEquals("эта еда не находится в этой тарелке", logger.get(0));
    }

    @Test
    public void eatLittle() {
        plate.addFood(fish, 18);
        male.eat(fish, 2, plate);
        assertEquals("Цопа попробовал немного Рыба", logger.get(0));
    }

    @Test
    public void eat() {
        plate.addFood(fish, 18);
        male.eat(fish, 7, plate);
        assertEquals("Цопа попробовал Рыба", logger.get(0));
    }

    @Test
    public void femaleCry() {
        female.cry();
        assertEquals("На глазах у Ксения выступают(-ет) Горькие слезы", logger.get(0));
        assertTrue(female.getMood().equals(MoodType.SAD));
    }

    @Test
    public void maleCry() {
        male.cry();
        assertEquals("На глазах у Цопа выступают(-ет) Скупая мужская слеза", logger.get(0));
        assertTrue(male.getMood().equals(MoodType.SAD));
    }

    @Test
    public void youngCry() {
        young.cry();
        assertEquals("На глазах у Мироша выступают(-ет) Слезы", logger.get(0));
        assertTrue(young.getMood().equals(MoodType.SAD));
    }

    @Test
    public void smile() {
        female.smile();
        assertEquals("Ксения улыбается", logger.get(0));
        assertTrue(female.getMood().equals(MoodType.HAPPY));
    }

    @Test
    public void lookAtRight() {
        male.lookAt(female);
        assertEquals("Цопа смотрит на Ксения", logger.get(0));
        assertTrue(Math.abs(male.getCoordinates().getOrientation() - 0.8567056) <= 0.00001d);
    }

    @Test
    public void lookAtLeft() {
        male.lookAt(young);
        assertEquals("Цопа смотрит на Мироша", logger.get(0));
        assertTrue(Math.abs(male.getCoordinates().getOrientation() - 4.489967d) <= 0.00001d);
    }

}