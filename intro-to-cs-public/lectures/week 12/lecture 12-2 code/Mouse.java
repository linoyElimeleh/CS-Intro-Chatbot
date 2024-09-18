/** A mouse. */
public class Mouse implements Animal {
	
    String food = "crumbs";
	
    /** Constructs a mouse. */
    public Mouse() {
    }

    /** The sound of this mouse. */
    public String sound() { return "squeak"; }

    /** The food of this mouse. */
    public String eats() { return food; }

} 
