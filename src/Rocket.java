import java.util.ArrayList;

public class Rocket implements Spaceship {

    private ArrayList<Item> items;
    private int cost;
    private double rocketWeight;
    private double maxWeight;
    private int id;

    /**
     * Rocket constructor
     * @param cost dollar ($) cost of rocket in Millions
     * @param rocketWeight weight of unloaded rocket in kilograms
     * @param maxWeight max weight of rocket including cargo in kilograms
     */
    public Rocket(int cost, double rocketWeight, double maxWeight) {
        items = new ArrayList<>();
        this.id = -1;
        this.cost = cost;
        this.rocketWeight = rocketWeight;
        this.maxWeight = maxWeight;
    }

    /**
     * Returns dollar ($) cost of rocket in Millions.
     * @return the cost of the rocket
     */
    public int getCost() {
        return cost;
    }

    /**
     * Returns weight of unloaded rocket in kilograms.
     * @return the weight of the unloaded rocket
     */
    public double getRocketWeight() {
        return rocketWeight;
    }

    /**
     * Returns maximum weight of rocket plus cargo in kilograms.
     * @return the maximum weight of rocket plus cargo
     */
    public double getMaxWeight() {
        return maxWeight;
    }

    /**
     * Returns the rocket ID number
     * @return the rocket ID number
     */
    public int getId() {
        return id;
    }

    /**
     * Determine if launch was successful.
     * @return true if launch is a success, false if launch fails.
     */
    @Override
    public boolean launch() {
        return true;
    }

    /**
     * Determine if landing was successful.
     * @return true if landing is a success, false if landing fails.
     */
    @Override
    public boolean land() {
        return true;
    }

    /**
     * Determine if Item object can be loaded onto the rocket.
     * @param item the Item object to be loaded
     * @return true if the Item object can be loaded, false if the Item object cannot be loaded.
     */
    @Override
    public boolean canCarry(Item item) {
        return (getCargoWeight() + item.getWeight()) <= (maxWeight - rocketWeight);
    }

    /**
     * Add Item object to rocket's cargo
     * @param item the Item object to add.
     */
    @Override
    public void carry(Item item) {
        items.add(item);
    }

    /**
     * Calculate and return the combined weight of all Item objects loaded onto a rocket.
     * @return the combined weight of of all Item objects loaded onto a rocket
     */
    public double getCargoWeight() {
        double cargoWeight = 0;
        for (Item cargoItem : items) {
            cargoWeight = cargoWeight + cargoItem.getWeight();
        }
        return cargoWeight;
    }

}
