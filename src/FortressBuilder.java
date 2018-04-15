public interface FortressBuilder {
    void buildTower (Material material, int high, int radius, int buildDuration, Plate plate) throws FortressBuildException;
    void buildMoat (Material material, int deep, int width, int buildDuration, Plate plate) throws FortressBuildException;
    void buildWall (Material material, int high, int width, int buildDuration, Plate plate) throws FortressBuildException;
    static class FortressBuildException extends Exception {
        public FortressBuildException(){}
    }

}
