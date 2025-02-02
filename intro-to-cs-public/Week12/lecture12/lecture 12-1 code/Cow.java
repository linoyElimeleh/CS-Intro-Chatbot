/** A Cow */
public class Cow implements Animal {
    String food = "hay";
    int weight; 
    /** Constructs a cow. */
    public Cow(int weight) {
        this.weight = weight;
    }
    /** The sound of this cow. */
    public String sound() { return "moo"; }

    /** The food of this cow. */
    public String eats() { return food; }

    /** The weight of this cow */
    public double weight() { return weight; }
} 
