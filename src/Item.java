public class Item {

    private String name;
    private double weight;

    /**
     * Item constructor
     * @param name the name of the Item
     * @param weight the weight of the Item in kilograms
     */
    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Returns the name of the Item
     * @return the name of the Item
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the weight of the Item in kilograms.
     * @return the weight of the Item in kilograms
     */
    public double getWeight() {
        return weight;
    }
}
