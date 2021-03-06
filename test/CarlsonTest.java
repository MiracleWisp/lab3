import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CarlsonTest {
    static ArrayList<String> logger = new ArrayList<String>();
    static Plate plate = new Plate(25, 25, logger);
    static Carlson carlson = new Carlson("Carlson", 37, 20, 20, logger);
    static Food food = new Food(FoodType.CHICKEN, 7, logger);
    static Food wrongFood = new Food(FoodType.FISH, 4, logger);
    static Food liquidFood = new Food(FoodType.SOUP, 4, logger);


    @After
    public void cleanLog() {
        logger.clear();
        plate.clear();
    }

    @Before
    public void addFood() {
        plate.addFood(food, 4);
    }

    @Test(expected = FortressBuilder.FortressBuildException.class)
    public void towerRadius1() throws Exception {
        carlson.buildTower(food, 53, -20, 3, plate);
    }

    @Test(expected = FortressBuilder.FortressBuildException.class)
    public void towerRadius2() throws Exception {
        carlson.buildTower(food, 53, -1, 3, plate);
    }

    @Test(expected = FortressBuilder.FortressBuildException.class)
    public void towerRadius3() throws Exception {
        carlson.buildTower(food, 53, 0, 3, plate);
    }

    @Test(expected = FortressBuilder.FortressBuildException.class)
    public void towerRadius4() throws Exception {
        carlson.buildTower(food, 53, 26, 3, plate);
    }

    @Test(expected = FortressBuilder.FortressBuildException.class)
    public void towerRadius5() throws Exception {
        carlson.buildTower(food, 53, 50, 3, plate);
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
    public void rightTowerLog1() throws Exception {
        carlson.buildTower(food, 32, 1, 3, plate);
        assertEquals("Carlson построил башню из Курица", logger.get(0));
    }

    @Test
    public void rightTowerLog2() throws Exception {
        carlson.buildTower(food, 32, 15, 3, plate);
        assertEquals("Carlson построил башню из Курица", logger.get(0));
    }

    @Test
    public void rightMoatLog() throws Exception {
        plate.addFood(liquidFood, 4);
        carlson.buildMoat(liquidFood, 22, 22, 3, plate);
        assertEquals("Carlson вырыл ров и заполнил его Суп", logger.get(0));
    }

    @Test
    public void rightTowerLog3() throws Exception {
        carlson.buildTower(food, 32, 25, 3, plate);
        assertEquals("Carlson построил башню из Курица", logger.get(0));
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