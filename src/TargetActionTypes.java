import java.util.ArrayList;

public enum TargetActionTypes {
    FRIGHTENINGLY{
        @Override
        public String getType() {
            return "пугающе";
        }

        @Override
        public void effect(Creature c, ArrayList<String> logger) {
            logger.add(c.getName() + " глотнул воздух и промолчал");
            c.setMood(MoodType.SCARED);
        }
    },
    CONSCIOUSLY{
        @Override
        public String getType() {
            return "сочувственно";
        }

        @Override
        public void effect(Creature c, ArrayList<String> logger) {
            c.setMood(MoodType.HAPPY);
        }
    },
    CONTEMPTUOUSLY{
        @Override
        public String getType() {
            return "презрительно";
        }

        @Override
        public void effect(Creature c, ArrayList<String> logger) {
            c.setMood(MoodType.SAD);
        }
    };

    abstract public void effect(Creature c, ArrayList<String> logger);
    abstract public String getType();
}
