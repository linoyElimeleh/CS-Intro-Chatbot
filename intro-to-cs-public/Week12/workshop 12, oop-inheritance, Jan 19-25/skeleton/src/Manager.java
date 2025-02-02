// Subclass of Employee
public class Manager extends Employee {
    private double bonusMultiplier;

    // Constructor
    public Manager(String name, int id, double salary, double bonusMultiplier) {
        super(name, id, salary);
        this.bonusMultiplier = bonusMultiplier;
    }

    // Override calculateBonus() method by adding 20% bonus
    @Override
    public double calculateBonus() {
        // TODO: Implement bonus calculation for managers
        return 0.0;
    }

    // TODO: Test overloaded calculateBonus(double additionalBonus)
}