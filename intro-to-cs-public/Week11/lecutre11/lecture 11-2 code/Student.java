/** Represents a student. */
public class Student extends Person {

    // Student-specific fields:
    private int studentId;
    private String club; 

    /** Constructs a student. */
    public Student(String name, String address, int studentId, String club) {
        super(name, address); // calls the super constructor
        this.studentId = studentId;
        this.club = club;
    }

    /** Sets the club membership of this student. */
    public void setClub(String club) {
        this.club = club;
    }

    /** Gets the club membership of this student. */
    public String getClub() {
        return club;
    }

    /** Implements the abstract method from Person. */
    @Override
    public String getRole() {
        return "Student";
    }

    /** Textual description of this student. */
    @Override
    public String toString() {
        return super.toString() + ", id: " + studentId + ", club: " + club;
    }
}
