public class U1 extends Rocket {

    private static int count = 0;

    private int id;

    public U1() {
        super(100, 10000, 18000);
        count++;
        this.id = count;
    }

    /**
     * Determine if launch was successful.
     * @return true if launch is a success, false if launch fails.
     */
    @Override
    public boolean launch() {
        int random = (int) (Math.random() * 100) + 1;
        return random > (5.0 * getCargoWeight() / (getMaxWeight() - getRocketWeight()));
    }

    /**
     * Determine if landing was successful.
     * @return true if landing is a success, false if landing fails.
     */
    @Override
    public boolean land() {
        int random = (int) (Math.random() * 100) + 1;
        return random > (1.0 * getCargoWeight() / (getMaxWeight() - getRocketWeight()));
    }

    /**
     * Returns static count of U1 objects created
     * @return the static count of U1 objects
     */
    public static int getCount() {
        return count;
    }

    /**
     * Returns the rocket ID number
     * @return the rocket ID number
     */
    public int getId() {
        return id;
    }
}
