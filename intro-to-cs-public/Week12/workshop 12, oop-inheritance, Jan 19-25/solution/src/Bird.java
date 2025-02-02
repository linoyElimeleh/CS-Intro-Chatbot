// Subclass of Animal
public class Bird extends Animal {

    // Constructor
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp chirp!");
    }

    @Override 
    public void move() {
        System.out.println("Flying through the air...");
    }
}