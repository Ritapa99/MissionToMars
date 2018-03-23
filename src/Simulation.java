
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    /**
     * Loads in items from the given filename. Format of the file is "itemName=weightInKilograms"
     * @param filename the filename of the input file
     * @return an ArrayList of the Item objects created
     */
    public ArrayList<Item> loadItems(String filename) {
        ArrayList<Item> items = new ArrayList<>();
        File file = new File(filename);

        try {
            Scanner in = new Scanner(file);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                int index = line.indexOf("=");
                String name = line.substring(0, index);
                double weight = Double.parseDouble(line.substring(index + 1));
                Item item = new Item(name, weight);
                items.add(item);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File " + filename + " not found!");
        }

        return items;
    }

    /**
     * Load items into U1 rockets
     * @param items an ArrayList of Item objects
     * @return an ArrayList of Rocket objects loaded with the given Item objects
     */
    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList<>();

        while(items.size() > 0) {
            // create new U1
            U1 u1 = new U1();

            if (Main.VERBOSE) {
                System.out.println("  U1 rocket #" + U1.getCount());
                System.out.println("  -----------------------------");
            }

            // fill U1 with items until full
            for (int i = items.size() - 1; i >= 0; i--) {
                if (u1.canCarry(items.get(i))) {
                    u1.carry(items.get(i));
                    if (Main.VERBOSE) {
                        System.out.println("  " + items.get(i).getName() + " " + items.get(i).getWeight());
                    }
                    items.remove(i);
                }
            }

            // add U1 to list
            rockets.add(u1);
            if (Main.VERBOSE) {
                System.out.println("  Total Cargo: " + u1.getCargoWeight());
                System.out.println("");
            }
        }

        return rockets;
    }

    /**
     * Load items into U2 rockets
     * @param items an ArrayList of Item objects
     * @return an ArrayList of Rocket objects loaded with the given Item objects
     */
    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList<>();

        while(items.size() > 0) {
            // create new U2
            U2 u2 = new U2();

            if (Main.VERBOSE) {
                System.out.println("  U2 rocket #" + U2.getCount());
                System.out.println("  -----------------------------");
            }

            // fill U2 with items until full
            for (int i = items.size() - 1; i >= 0; i--) {
                if (u2.canCarry(items.get(i))) {
                    u2.carry(items.get(i));
                    if (Main.VERBOSE) {
                        System.out.println("  " + items.get(i).getName() + " " + items.get(i).getWeight());
                    }
                    items.remove(i);
                }
            }

            // add U2 to list
            rockets.add(u2);
            if (Main.VERBOSE) {
                System.out.println("  Total Cargo: " + u2.getCargoWeight());
                System.out.println("");
            }
        }

        return rockets;
    }

    /**
     * Launches the rockets. If a rocket fails on launch or fails to land, the rocket is relaunched.
     * A running tally of rocket cost is tabulated including the cost of failed rockets.
     * @param rockets an ArrayList of Rocket objects to launch
     * @return the tabulated cost to launch all rockets, including failed rockets.
     */
    public int runSimulation(ArrayList<Rocket> rockets) {
        int totalCost = 0;

        for (int i = rockets.size() - 1; i >= 0; i--) {
            boolean launch;
            boolean land;
            do {
                totalCost = totalCost + rockets.get(i).getCost();
                launch = rockets.get(i).launch();
                land = rockets.get(i).land();
                if (Main.VERBOSE) {
                    if (!launch) {
                        System.out.println("  Rocket " + rockets.get(i).getId() + " exploded on launch! Will rebuild rocket and re-launch.");
                    } else {
                        System.out.print("  Rocket " + rockets.get(i).getId() + " successfully launched... ");
                        if (!land) {
                            System.out.println(" but crashed on landing! Will rebuild rocket and re-launch.");
                        } else {
                            System.out.println(" and landed on its mark!");
                        }
                    }

                }
            } while (!launch || !land);
            rockets.remove(i);
        }

        if (Main.VERBOSE) {
            System.out.println("");
        }

        return totalCost * 1000000;
    }
}
