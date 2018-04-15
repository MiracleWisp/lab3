import java.util.ArrayList;

abstract class Creature {
    ArrayList<String> logger;

    static class Coordinates {
        private int x;
        private int y;
        private double orientation = 0;

        public void setCoordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setOrientation(double orientation) {
            this.orientation = orientation;
        }

        public double getOrientation() {
            return orientation;
        }

        static double getDistanceBetween(Creature from, Creature to) {
            return Math.sqrt(Math.pow(to.coordinates.x - from.coordinates.x, 2) + Math.pow(to.coordinates.y - from.coordinates.y, 2));
        }

        /*static void printDistanceBetween(Creature from, Creature to){
            double distance = getDistanceBetween(from, to);
            if (distance < 3) logger.add(from.name + " стоит рядом с " + to.name);
            else if (distance < 6) logger.add(from.name + " стоит не очень далеко от " + to.name);
            else logger.add(from.name + " стоит далеко от " + to.name);
        }*/

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinates(int x, int y, int orientation) {
            this.x = x;
            this.y = y;
            this.orientation = orientation;
        }
    }

    private Coordinates coordinates;
    private MoodType mood = MoodType.HAPPY;
    private int age;
    private String name;
    private boolean isMale;

    private long lastActionEndTime;
    private String currentAction = "ничего не делает";

    public void setLastActionEndTime(long lastActionEndTime) {
        this.lastActionEndTime = lastActionEndTime;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public long getLastActionEndTime() {
        return lastActionEndTime;
    }

    public boolean checkDoingSmth() {
        return System.currentTimeMillis() < lastActionEndTime;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(Food f, int quantity, Plate plate) {
        if (plate.getMaterialsInPlate().contains(f)) {
            if (quantity < 5) logger.add(name + " попробовал немного " + f.getStringFoodType());
            else logger.add(name + " попробовал " + f.getStringFoodType());
            f.effect(this);
            plate.setFullness(plate.getFullness() - quantity);
        } else logger.add("эта еда не находится в этой тарелке");
    }

    public void cry() {
        class Tears {
            private String tearsType;

            public String getTearsType() {
                return tearsType;
            }

            public Tears(int age, boolean isMale) {
                if (!isMale)
                    tearsType = "Горькие слезы";
                else if (age >= 18)
                    tearsType = "Скупая мужская слеза";
                else tearsType = "Слезы";
            }
        }
        Tears tears = new Tears(age, isMale);
        mood = MoodType.SAD;
        logger.add("На глазах у " + name + " выступают(-ет) " + tears.getTearsType());
    }

    public void smile() {
        logger.add(name + " улыбается");
        mood = MoodType.HAPPY;
    }


    public void nod() {
        logger.add(name + " кивнул");
    }

    public void nod(Creature c, TargetActionTypes type) {
        logger.add(name + " " + type.getType() + " кивнул в сторону " + c.getName());
        type.effect(c, logger);
    }

    public void lookAt(Creature c) {
        logger.add(name + " смотрит на " + c.getName());
        double orientation = (double) (c.coordinates.y - coordinates.y) / (c.coordinates.x - coordinates.x);
        orientation = Math.atan(orientation);
        if ((c.coordinates.x - coordinates.x) < 0) orientation = orientation + 3.14;
        coordinates.setOrientation(orientation);
    }

    public void lookAt(Creature c, TargetActionTypes type) {
        logger.add(name + " " + type.getType() + " смотрит на " + c.getName());
        type.effect(c, logger);
        double orientation = (double) (c.coordinates.y - coordinates.y) / (c.coordinates.x - coordinates.x);
        orientation = Math.atan(orientation);
        if ((c.coordinates.x - coordinates.x) < 0) orientation = orientation + 3.14;
        coordinates.setOrientation(orientation);

    }

    public void setMood(MoodType mood) {
        this.mood = mood;
    }

    public MoodType getMood() {
        return mood;
    }

    public void moveTo(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Creature(String name, int age, boolean isMale, int x, int y, ArrayList<String> logger) {
        this.logger = logger;
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        coordinates = new Coordinates(x, y);
    }

    @Override
    public String toString() {
        return getName() + " " + getAge();
    }


    @Override
    public int hashCode() {
        return getAge() + getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (this.hashCode() == obj.hashCode());
    }
}
