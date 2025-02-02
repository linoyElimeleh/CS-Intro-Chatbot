public class Main {
    public static void main(String[] args) {

        // Activity 1
        // TODO: Create objects of Circle and Rectangle
        // TODO: Call area() and perimeter() for each object
        // TODO: Print details like color, area, and perimeter







        // Activity 2
        // Create objects of Manager and Developer
        Manager manager = new Manager("Alice", 101, 80000, 0.2); // 20% bonus
        Developer developer = new Developer("Bob", 102, 60000, "Java");

        // Test overridden calculateBonus()
        System.out.println(manager.getName() + "'s bonus: " + manager.calculateBonus());
        System.out.println(developer.getName() + "'s bonus: " + developer.calculateBonus());

        // Test overloaded calculateBonus(double additionalBonus)
        System.out.println(manager.getName() + "'s bonus with additional $5000: " +
                            manager.calculateBonus(5000));
        System.out.println(developer.getName() + "'s bonus with additional $3000: " +
                            developer.calculateBonus(3000));

        // TODO: Add a toString() implementation and print details


        // Activity 3
        // TODO: Create a list of Animal objects (e.g., Mammal and Bird)
        // TODO: Iterate over the list and call makeSound() and move()
        // TODO: Demonstrate polymorphism in action
    }
}