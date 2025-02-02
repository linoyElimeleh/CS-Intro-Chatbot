// This class was created by Intro to Computer Science staff 2022 - 2023 at Reichman University
// was used for finals moed B 2022-2023
// was given as API and some were needed to solved as part of the test
// Implementation wasn't shown in the exam
// implemented by: Tal Danai, position: Recitation TA
public class Worker {
    protected String name;
    protected int salary;
    // API
    // Constructor
    /**
     * Constructs a new worker with the given name and salary, saves in the field as lower case .
     * if the salary is negative or zero, an IllegalArgumentException is thrown.
     * @param name - the name of the worker
     * @param salary - the salary of the worker
     */
    public Worker (String name, int salary){
        if (salary <= 0){
            throw new IllegalArgumentException();
        }
        this.name = name.toLowerCase();
        this.salary = salary;
    }
    // Getters
    // Returns the name of the worker
    public String getName(){
        return this.name;
    }
    
    // Returns the salary of the worker
    public int getSalary(){
        return this.salary;
    }
    
    /**
     * returns true if the given object is a worker with the same name and salary, false otherwise
     * it overrides the equals method in the Object class
     * @param obj - the object to compare to
     * @return true if the given object is a worker with the same name and salary, false otherwise
     */
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()){
            return false;   
        }
        Worker other = (Worker)obj;
        return this.name.toLowerCase().equals(other.name.toLowerCase()) && other.salary == this.salary;
        
    }

    // Returns true if the worker is a manager, false otherwise
    public boolean isManager(){
        return false;
    }
    // Returns a string representation of the worker
    public String toString(){
        return "Name: " + this.name + " ,Salary:" + this.salary;
    } 

    // Q4
    public void raiseSalary(int amount){
        // TODO: implement this function
    }
    
}
