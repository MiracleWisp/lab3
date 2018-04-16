import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class PlateTest {
    ArrayList<String> logger = new ArrayList<String>();
    Plate plate = new Plate(4, 5, logger);
    Food food = new Food(FoodType.SOUP);

    @Test
    public void emptyPlateStatus() throws Exception {
        plate.getPlateStatus();
        assertEquals("Тарелка пустая", logger.get(0));
    }

    @Test
    public void aboutEmptyPlateStatus() throws Exception {
        plate.addFood(new Food(FoodType.CHICKEN), 25);
        plate.getPlateStatus();
        assertEquals("Тарелка почти пустая", logger.get(0));
    }

    @Test
    public void middleFilledPlateStatus() throws Exception {
        plate.addFood(new Food(FoodType.CHICKEN), 75);
        plate.getPlateStatus();
        assertEquals("В тарелке достаточно еды", logger.get(0));
    }

    @Test
    public void aboutFullPlateStatus() throws Exception {
        plate.addFood(new Food(FoodType.CHICKEN), 99);
        plate.getPlateStatus();
        assertEquals("Тарелка почти полная", logger.get(0));
    }

    @Test
    public void fullPlateStatus() throws Exception {
        plate.addFood(new Food(FoodType.CHICKEN), 100);
        plate.getPlateStatus();
        assertEquals("Тарелка полная", logger.get(0));
    }

    @Test
    public void fillMaterialsInPlate() throws Exception {
    }

    @Test
    public void clearTest() throws Exception {
        plate.addFood(new Food(FoodType.CHICKEN), 100);
        assertTrue(!plate.getMaterialsInPlate().isEmpty());
        plate.clear();
        for (Food f : plate.getFoodInPlate()) {
            assertTrue(f == null);
        }
        assertTrue(plate.getMaterialsInPlate().isEmpty() && plate.getFullness() == 0);
    }

    @Test
    public void addFood() throws Exception {
        plate.addFood(food, 5);
        assertTrue(plate.getFoodInPlate()[food.getType().ordinal()] == food);
    }

}