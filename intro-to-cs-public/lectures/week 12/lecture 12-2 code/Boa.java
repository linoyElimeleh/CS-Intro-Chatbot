/** A boa. */
public class Boa implements Animal {
	
    // The food of this boa
    Animal food;
	
    /** Constructs a boa and feeds it right away */
    public Boa(Animal a) {
        food = a;
    }

    /** The sound that this boa makes. */
    public String sound() {
        return "((" + food.sound() + "))";
    }
    
    /** The food of this boa. */
    public Animal eats() { return food; }
}
