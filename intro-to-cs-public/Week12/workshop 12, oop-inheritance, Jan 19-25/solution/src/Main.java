public class Main {
    public static void main(String[] args) {

        // Activity 1
        Circle circle = new Circle("Red", 5.0);
        Rectangle rectangle = new Rectangle("Blue", 4.0, 6.0);

        System.out.println("Circle Details:");
        System.out.println("Color: " + circle.getColor());
        System.out.println("Area: " + circle.area());
        System.out.println("Perimeter: " + circle.perimeter());

        System.out.println("\nRectangle Details:");
        System.out.println("Color: " + rectangle.getColor());
        System.out.println("Area: " + rectangle.area());
        System.out.println("Perimeter: " + rectangle.perimeter());

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

        // Print employee details using toString()
        System.out.println("\nEmployee Details:");
        System.out.println(manager);
        System.out.println(developer);

        // Activity 3
        Animal[] animals = new Animal[2];
        animals[0] = new Bird("Tweety", 2); // Directly assign objects to array indices
        animals[1] = new Mammal("Fluffy", 3);

        System.out.println("\nAnimal Activities:");
        for (Animal animal : animals) {
            System.out.println("\n" + animal.getName() + ":");
            animal.makeSound();
            animal.move();
        }
    }
}