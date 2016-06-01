package me.arkadiy.gumenniy.model.entity;

/**
 * describes some sweet
 */
public class Sweet {
    /**
     * sweet type
     */
    private SweetType sweetType;
    /**
     * sweet name
     */
    private String name;
    /**
     * sweet weight
     */
    private float weight;
    /**
     * price of single item
     */
    private float price;
    /**
     * proportion of sugar in percents
     */
    private int sugarProportion;

    public Sweet(String name, SweetType sweetType, float weight, float price, int sugarProportion) {
        this.name = name;
        this.sweetType = sweetType;
        this.weight = weight;
        this.price = price;
        this.sugarProportion = sugarProportion;
    }

    public Sweet(Sweet item) {
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
        return "Sweet{" +
                "sweetType=" + sweetType +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", sugarProportion=" + sugarProportion +
                '}';
    }
}
