/** Represents an instructor. */
public class Instructor extends Person {

   // Instructor fields: 
   private String title; 

   /** Constructs an instructor. */
   public Instructor(String name, String address, String title) {
      super(name, address); // calls the super constructor 
      this.title = title;
   }

   /** Sets the title of this instructor. */
   public void setTitle(String title) {
      this.title = title;
   } 

   /** Textual description of this instructor. */
   public String toString() {
      return title + " " + super.toString();
   }

   // More Instructor methods 
}
