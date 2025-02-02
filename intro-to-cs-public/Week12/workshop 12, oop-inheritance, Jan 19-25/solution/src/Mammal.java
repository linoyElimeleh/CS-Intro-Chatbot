// Subclass of Animal
public class Mammal extends Animal {

    // Constructor
    public Mammal(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Roar!");
    }

    @Override
    public void move() {
        System.out.println("Running on four legs...");
    }
}