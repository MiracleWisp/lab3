public class Tower extends FortressPart {

    private int high;
    private int radius;

    public void setHigh(int high) {
        this.high = high;
    }

    public int getHigh() {
        return high;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public Tower(Material material, int high, int radius){
        super(material);
        this.high = high;
        this.radius = radius;
    }

    @Override
    public int hashCode() {
        return getHigh() + getRadius() + getMaterial().hashCode();
    }

    @Override
    public String toString() {
        return "Башня из " + getMaterial() +" с высотой - " + high + " и радиусом - " + radius;
    }

}
