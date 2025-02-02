// Base class
public class Employee {
    private String name;
    private int id;
    private double salary;

    // Constructor
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    // Method to calculate bonus
    public double calculateBonus() {
        // Default bonus calculation
        return salary * 0.1;
    }

    // Overloaded calculateBonus method
    public double calculateBonus(double additionalBonus) {
        // Calculates bonus with an additional multiplier
        return (salary * 0.1) + additionalBonus;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "name='" + name + '\'' +
               ", id=" + id +
               ", salary=" + salary +
               '}';
    }
}