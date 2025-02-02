/** Represents a person. */
public class Person {

    // Person fields
    protected String name;
    protected String address;
        
    /** Constructs a Person */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }    
    
    /** Sets the address of this person. */
    public void setAddress(String address) {
        this.address = address;
    }    
                
    /** Textual description of this person. */
    public String toString() {
        return name + ", " + address;
    }   
    // More Person methods           
}
