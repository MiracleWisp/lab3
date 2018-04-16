import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        ArrayList<String> logger = new ArrayList<String>();
        Human junior = new Human("Малыш", "Свантесон", 11, true, 1,6,logger);
        Human frekenBock = new Human("Фрекен", "Бок", 44, false,4,2,logger);
        Carlson karlson = new Carlson("Карлсон", 35,1,4,logger);
        Plate plate  = new Plate(4, 5, logger);


        karlson.nod(junior, TargetActionTypes.CONSCIOUSLY);


        Food meat =  null; //karlson.makeFood(FoodType.MEAT, 35, plate);
        Food sauce = karlson.makeFood(FoodType.SAUCE, 65, plate);
        plate.getPlateStatus();



        try {
            karlson.buildTower(meat, 3, 1, 30000000, plate);
        }
        catch (FortressBuilder.FortressBuildException e) {
            logger.add("Не удалось построить башню с заданными параметрами");
        }
        catch (NullPointerException e) {
            logger.add("Нельзя построить башню из несуществующего материала");
        }

        try {
            karlson.buildMoat(new Material() {
                @Override
                public String getMaterialType() {
                    return "Соус";
                }
                @Override
                public boolean isLiquid(){
                    return true;
                }
            }, 1, 1, 3000000, plate);
        }
        catch (FortressBuilder.FortressBuildException e){
            logger.add("Не вырыть ров с заданными параметрами");
        }
        catch (NullPointerException e) {
            logger.add("Нельзя вырыть ров из несуществующего материала");
        }

        if (karlson.checkDoingSmth()) logger.add("Пока " + karlson.getName() + " делает что-то");


        junior.eat(meat, 2, plate);
        /*Creature.Coordinates.printDistanceBetween(frekenBock,junior);*/
        frekenBock.lookAt(junior, TargetActionTypes.FRIGHTENINGLY);

        for(int i=0; i<logger.size();i++){
            System.out.println(logger.get(i));
        }
    }
}
