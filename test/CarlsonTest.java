import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CarlsonTest {
    static ArrayList<String> logger = new ArrayList<>();
    static Plate plate = new Plate(25, 25, logger);
    static Carlson carlson = new Carlson("Carlson", 37, 20, 20, logger);
    static Food food = new Food(FoodType.CHICKEN, 7, logger);
    static Food wrongFood = new Food(FoodType.FISH, 4, logger);
    static Food liquidFood = new Food(FoodType.SOUP, 4, logger);

    @BeforeClass
    public static void before() {
        plate.addFood(food, 4);
    }

    @After
    public void cleanLog() {
        logger.clear();
        plate.clear();
    }

    @Test(expected = FortressBuilder.FortressBuildException.class)
    public void towerBigRadius() throws Exception {
        carlson.buildTower(food, 53, 26, 3, plate);
    }

    @Test(expected = FortressBuilder.FortressBuildException.class)
    public void towerNegativeRadius() throws Exception {
        carlson.buildTower(food, 53, -26, 3, plate);
    }

    @Test(expected = FortressBuilder.FortressBuildException.class)
    public void towerWrongFood() throws Exception {
        carlson.buildTower(wrongFood, 53, 22, 3, plate);
    }

    @Test(expected = FortressBuilder.FortressBuildException.class)
    public void liquidTower() throws Exception {
        plate.addFood(liquidFood, 5);
        carlson.buildTower(liquidFood, 53, 22, 3, plate);
    }

    @Test
    public void rightTowerLog() throws Exception {
        carlson.buildTower(food, 32, 22, 3, plate);
        assertEquals("Carlson построил башню из Курица", logger.get(0));
    }

    @Test
    public void rightMoatLog() throws Exception {
        plate.addFood(liquidFood, 4);
        carlson.buildMoat(liquidFood, 22, 22, 3, plate);
        assertEquals("Carlson вырыл ров и заполнил его Суп", logger.get(0));
    }

    @Test
    public void rightWall() throws Exception {
        carlson.buildWall(food, 32, 22, 3, plate);
        assertEquals("Carlson построил стену из Курица", logger.get(0));
    }

    @Test
    public void makeFood() throws Exception {
        carlson.makeFood(FoodType.SOUP, 4, plate);
        assertEquals("Carlson приготовил Суп", logger.get(0));
    }

}