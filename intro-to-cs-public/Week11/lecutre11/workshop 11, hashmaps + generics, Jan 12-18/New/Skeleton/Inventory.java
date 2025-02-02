import java.util.HashMap;

/** Represents a simple Inventory Management System using HashMap. */
public class Inventory {
    private HashMap<String, Integer> items;

    /** Constructs an empty inventory. */
    public Inventory() {
        items = new HashMap<>();
    }

    /** Adds the specified quantity of an item to the inventory. */
    public void addItem(String itemName, int quantity) {
        // TODO: Implement this
    }

    /** Removes the specified quantity of an item from the inventory. */
    public void removeItem(String itemName, int quantity) {
        // TODO: Implement this
    }

    /** Returns the quantity of the specified item in the inventory. */
    public int checkStock(String itemName) {
        // TODO: Implement this
        return 0; // Placeholder
    }

    /** Lists all items and their quantities in the inventory. */
    public void listItems() {
        // TODO: Implement this
    }

    /** Example usage of the Inventory class. */
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addItem("Apples", 10);
        inventory.addItem("Bananas", 20);

        System.out.println("Stock of Apples: " + inventory.checkStock("Apples"));

        inventory.listItems();

        inventory.removeItem("Apples", 5);
        System.out.println("Stock of Apples after removal: " + inventory.checkStock("Apples"));

        inventory.listItems();
    }
}
