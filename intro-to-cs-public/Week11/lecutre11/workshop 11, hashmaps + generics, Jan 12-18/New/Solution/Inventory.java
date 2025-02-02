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
        items.put(itemName, items.getOrDefault(itemName, 0) + quantity);
        System.out.println(quantity + " " + itemName + "(s) added.");
    }

    /** Removes the specified quantity of an item from the inventory. */
    public void removeItem(String itemName, int quantity) {
        if (!items.containsKey(itemName)) {
            System.out.println("Item not found.");
            return;
        }
        int currentStock = items.get(itemName);
        if (currentStock <= quantity) {
            items.remove(itemName);
            System.out.println(itemName + " removed from inventory.");
        } else {
            items.put(itemName, currentStock - quantity);
            System.out.println(quantity + " " + itemName + "(s) removed.");
        }
    }

    /** Returns the quantity of the specified item in the inventory. */
    public int checkStock(String itemName) {
        return items.getOrDefault(itemName, 0);
    }

    /** Lists all items and their quantities in the inventory. */
    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (String itemName : items.keySet()) {
                System.out.println(itemName + ": " + items.get(itemName));
            }
        }
    }

    /** Example usage of the Inventory class. */
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Add items
        inventory.addItem("Apples", 10);
        inventory.addItem("Bananas", 20);

        // Check stock
        System.out.println("Stock of Apples: " + inventory.checkStock("Apples"));

        // List items
        inventory.listItems();

        // Remove items
        inventory.removeItem("Apples", 5);
        System.out.println("Stock of Apples after removal: " + inventory.checkStock("Apples"));

        // List items after removal
        inventory.listItems();
    }
}
