public class Wall extends FortressPart {
    private int high;
    private int width;

    public int getHigh() {
        return high;
    }

    public int getWidth() {
        return width;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public Wall(Material material, int high, int width){
        super(material);
        this.high = high;
        this.width = width;
    }

    @Override
    public int hashCode() {
        return getHigh() + getWidth() + getMaterial().hashCode();
    }

    @Override
    public String toString() {
        return "Стена из " + getMaterial() +" с высотой - " + high + " и шириной - " + width;
    }
}
