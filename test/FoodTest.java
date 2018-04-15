import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FoodTest {
    ArrayList<String> logger = new ArrayList<>();
    Food fish = new Food(FoodType.FISH, 7, logger);
    Food soup = new Food(FoodType.SOUP, 7, logger);
    Creature c = new Human("Иван", "Усков", 21,
            true,5,7,logger);
    Creature young = new Carlson("Цопа",17,
            5,4,logger);

    @Before
    public void cleanLog(){
        logger.clear();
    }

    @Test
    public void effectOfFish(){
        fish.effect(c);
        assertEquals("Иван подавился костью рыбы", logger.get(0));
    }

    @Test
    public void effectOfSoup(){
        soup.effect(c);
        assertEquals("Иван обжегся горячим супом",logger.get(0));
    }

    @Test
    public void youngEffectOfSoup(){
        soup.effect(young);
        assertEquals("Цопа ест суп через силу, т.к. не любит его", logger.get(0));
    }


}