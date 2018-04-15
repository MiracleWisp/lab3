import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FoodTest {
    ArrayList<String> logger = new ArrayList<>();
    Food f = new Food(FoodType.FISH, 7, logger);
    @Test
    public void getType() throws Exception {
        assertEquals(FoodType.FISH,f.getType());
    }

    @Test
    public void getStringFoodType() throws Exception {
        assertTrue(f.getStringFoodType().equals("Рыба"));
    }

}