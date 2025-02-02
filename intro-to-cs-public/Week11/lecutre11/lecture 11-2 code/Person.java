/** Represents a person. */
public abstract class Person {

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

    /** Gets the role of this person. */
    // Abstract method, to be implemented by sub-clasees.    
    public abstract String getRole();
                
    /** Textual description of this person. */
    public String toString() {
        return getRole() + " " + name + ", " + address;
    }   
    // More Person methods           
}
