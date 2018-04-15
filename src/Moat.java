public class Moat extends FortressPart {

    private int deep;
    private int width;

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public int getDeep() {
        return deep;
    }

    public Moat(Material material, int deep, int width) {
        super(material);
        this.deep = deep;
        this.width = width;
    }

    @Override
    public int hashCode() {
        return getDeep() + getWidth() + getMaterial().hashCode();
    }

    @Override
    public String toString() {
        return "Ров заполенный " + getMaterial() +" с глубиной - " + deep + " и шириной - " + width;
    }


}
