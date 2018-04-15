abstract public class FortressPart {

    private String material;


    public void setMaterial(Material material) {
        this.material = material.getMaterialType();
    }

    public String getMaterial() {
        return material;
    }

    public FortressPart(Material material){
        setMaterial(material);
    }

    @Override
    public boolean equals(Object obj) {
        return (this.hashCode() == obj.hashCode());
    }
}
