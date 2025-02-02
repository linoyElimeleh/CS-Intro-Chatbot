// Subclass of Employee
public class Manager extends Employee {
    private double bonusMultiplier;

    // Constructor
    public Manager(String name, int id, double salary, double bonusMultiplier) {
        super(name, id, salary);
        this.bonusMultiplier = bonusMultiplier;
    }

    // Override calculateBonus() method
    @Override
    public double calculateBonus() {
        return getSalary() * bonusMultiplier;
    }

    // Override overloaded calculateBonus method
    @Override
    public double calculateBonus(double additionalBonus) {
        return calculateBonus() + additionalBonus;
    }
}