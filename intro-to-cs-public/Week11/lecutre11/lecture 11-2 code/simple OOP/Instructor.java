/** Represents an instructor. */
public class Instructor extends Person {

   // Instructor-specific fields: 
   private String title;

   /** Constructs an instructor. */
   public Instructor(String name, String address, String title) {
      super(name, address); // calls the super constructor 
      this.title = title;
   }

   /** Textual description of this instructor. */
   @Override
   public String toString() {
      return title + " " + super.toString();
   }
   // More Instructor methods 
}

