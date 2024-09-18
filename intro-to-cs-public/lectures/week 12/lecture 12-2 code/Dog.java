/** A dog. */
public class Dog implements Animal {

    String food = "bonzo";
	
    /** Constructs a dog. */
    public Dog() {
    }

    /** The sound of this dog. */
    public String sound() { return "woof"; }

    /** The food of this dog. */
    public String eats() { return food; }
} 
