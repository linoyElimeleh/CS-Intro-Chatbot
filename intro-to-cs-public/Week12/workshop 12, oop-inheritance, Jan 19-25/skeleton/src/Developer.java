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

    // Override calculateBonus() method
    @Override
    public double calculateBonus() {
        return getSalary() * 0.15; // 15% bonus for developers
    }

    // TODO: Test overloaded calculateBonus(double additionalBonus)
}