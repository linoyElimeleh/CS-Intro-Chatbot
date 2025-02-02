// Subclass of Employee
public class Developer extends Employee {
    private String programmingLanguage;

    // Constructor
    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    // Getters
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    // Setters
    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    // Override calculateBonus() method
    @Override
    public double calculateBonus() {
        return getSalary() * 0.15; // 15% bonus for developers
    }

    // Overloaded calculateBonus method with additional bonus
    public double calculateBonus(double additionalBonus) {
        return calculateBonus() + additionalBonus;
    }

    @Override
    public String toString() {
        return "Developer{" +
               "name='" + getName() + '\'' +
               ", id=" + getId() +
               ", salary=" + getSalary() +
               ", programmingLanguage='" + programmingLanguage + '\'' +
               '}';
    }
}