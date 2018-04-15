import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Plate implements Comparable<Plate>{
    ArrayList<String> logger;
    private int deep;
    private int radius;
    private int numOfFood = 0;
    private int fullness;
    Fortress fortress;

    @Override
    public int compareTo(Plate plate) {
        return this.deep*this.radius - plate.deep*plate.radius;
    }

    class Fortress {
        private Wall wall = null;
        private Tower tower = null;
        private Moat moat = null;

        public void setMoat(Moat moat) {
            this.moat = moat;
        }

        public void setTower(Tower tower) {
            this.tower = tower;
        }

        public void setWall(Wall wall) {
            this.wall = wall;
        }

        public void destroyMoat(){
            moat = null;
        }
        public void destroyTower(){
            tower = null;
        }
        public void destroyWall(){
            wall = null;
        }

        public void getFortressInfo(){
            logger.add("Крепость состоит из:");

            if(moat!=null) logger.add("Ров: Глубина = " + moat.getDeep() + " Ширина = " + moat.getWidth());
            else logger.add("Ров отсутствует");

            if(wall!=null) logger.add("Стена: Высота = " + wall.getHigh() + " Ширина = " + wall.getWidth());
            else logger.add("Стена отсутствует");

            if(tower!=null) logger.add("Башня: Высота = " + tower.getHigh() + " Радиус = " + tower.getRadius());
            else logger.add("Башня отсутствует");
        }
    }

    public Fortress getFortress() {
        return fortress;
    }

    transient private HashSet<Material> materialsInPlate = new HashSet<Material>();

    public void fillMaterialsInPlate() {
        if (materialsInPlate == null) materialsInPlate = new HashSet<>();
        this.materialsInPlate.addAll(Arrays.asList(foodInPlate));
        materialsInPlate.remove(null);
    }

    public HashSet<Material> getMaterialsInPlate(){
        return materialsInPlate;
    }
    private Food[] foodInPlate = new Food[FoodType.values().length];

    public Food[] getFoodInPlate() {
        return foodInPlate;
    }

    public int getDeep() {
        return deep;
    }

    public int getRadius() {
        return radius;
    }

    public void addFood(Food f, int quantity) throws  PlateOverflowException{

        if (fullness < 100) {
            foodInPlate[f.getType().ordinal()] = f;
            materialsInPlate.add(f);
            //numOfFood++;
            fullness += quantity;
            if (fullness > 100) {
                throw new PlateOverflowException(f, fullness - 100);
            }
        }

    }

    public int getFullness() {
        return fullness;
    }

    public void setFullness(int fullness) {
        this.fullness = fullness;
    }

    public void getPlateStatus(){
        int status = fullness/25;
        if (fullness == 0) logger.add("Тарелка пустая");
        else if (fullness <= 25) logger.add("Тарелка почти пустая");
        else if (fullness <= 75) logger.add("В тарелке достаточно еды");
        else if (fullness < 100) logger.add("Тарлке почти полная");
        else if (fullness == 100) logger.add("Тарелка полная");
    }

    public Plate(int deep, int radius, ArrayList<String> logger) {
        this.logger=logger;
        this.deep = deep;
        this.radius = radius;
        fortress = new Fortress();
    }

    class PlateOverflowException extends RuntimeException{
        private int overflowValue = -1;
        private Food foodType;

        void getOverflowStatus() {
            if (overflowValue != -1) logger.add("Тарелка была переполнена " + foodType.toString() + " на " + overflowValue + " %.");
            else logger.add("Тарелка была переполнена на " + foodType.toString() + " неизвестное количество");;
        }

        public PlateOverflowException(Food f, int overflowValue)
        {
            this.overflowValue = overflowValue;
            foodType = f;
        }
    }
}
