package me.arkadiy.gumenniy.model.entity;

/**
 * Created by Arkadiy on 28.05.2016.
 */
public class PresentItem {
    private SweetType sweetType;
    private String name;
    private float weight;
    private float price;
    private int sugarProportion;

    public PresentItem(String name, SweetType sweetType, float weight, float price, int sugarProportion) {
        this.name = name;
        this.sweetType = sweetType;
        this.weight = weight;
        this.price = price;
        this.sugarProportion = sugarProportion;
    }

    public PresentItem(PresentItem item) {
        this(item.getName(), item.getSweetType(), item.getWeight(), item.getPrice(), item.getSugarProportion());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SweetType getSweetType() {
        return sweetType;
    }

    public void setSweetType(SweetType sweetType) {
        this.sweetType = sweetType;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSugarProportion() {
        return sugarProportion;
    }

    public void setSugarProportion(int sugarProportion) {
        if (sugarProportion > 100 || sugarProportion < 0)
            throw new IllegalArgumentException(
                    String.format("proportion is %d. Should be between 0 and 100 inclusive", sugarProportion));

        this.sugarProportion = sugarProportion;
    }

    @Override
    public String toString() {
        return "PresentItem{" +
                "sweetType=" + sweetType +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", sugarProportion=" + sugarProportion +
                '}';
    }
}
