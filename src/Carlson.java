import java.util.ArrayList;

public class Carlson extends Creature implements FortressBuilder{
    @Override
    public void buildTower(Material material, int high, int radius, int buildDuration, Plate plate) throws FortressBuildException {
        setLastActionEndTime(System.currentTimeMillis() + buildDuration);
        if (radius <= plate.getRadius() && radius > 0 && !material.isLiquid() && plate.getMaterialsInPlate().contains(material)){
        logger.add(getName() + " построил башню из " + material.getMaterialType());
        plate.fortress.setTower(new Tower(material, high, radius));
        }
        else{
            throw new FortressBuildException();

            //logger.add()(getName() + " не удалось построить с заданными параметрами ");
            //return null;
        }
    }

    @Override
    public void buildMoat(Material material, int deep, int width, int buildDuration, Plate plate ) throws FortressBuildException {
        if (deep <= plate.getDeep() && deep > 0 && material.isLiquid() && plate.getMaterialsInPlate().contains(material)){
            logger.add(getName() + " вырыл ров и заполнил его " + material.getMaterialType());
            plate.fortress.setMoat(new Moat(material, deep, width));
        }
        else{
            throw new FortressBuildException();
            //logger.add()(getName() + " не удалось вырыть ров с заданными параметрами ");
            //return null;
        }
    }

    @Override
    public void buildWall(Material material, int high, int width, int buildDuration, Plate plate) throws FortressBuildException {
        if (width < plate.getRadius() && width > 0 && !material.isLiquid() && plate.getMaterialsInPlate().contains(material)) {
            logger.add(getName() + " построил стену из " + material.getMaterialType());
            plate.fortress.setWall(new Wall(material, high, width));
        }
        else{
            throw new FortressBuildException();
            //logger.add()(getName() + " не удалось построить с заданными параметрами ");
            //return null;
        }
    }

    public Food makeFood (FoodType type, int quantity, Plate plate)
    {
        Food f = new Food(type);
        logger.add(getName() + " приготовил " + f.getStringFoodType());
        try {
            plate.addFood(f, quantity);
        }
        catch (Plate.PlateOverflowException e){
            plate.setFullness(100);
            e.getOverflowStatus();
        }
        return f;
    }

    public Carlson(String name, int age, int x, int y, ArrayList<String> logger) {
        super(name, age, true,x,y,logger);
    }
}
