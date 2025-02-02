// This class was created by Intro to Computer Science staff 2022 - 2023 at Reichman University
// was used for finals moed B 2022-2023
// was given as API and some were needed to solved as part of the test
// Implementation wasn't shown in the exam
// implemented by: Tal Danai, position: Recitation TA
public class Office {
    private Manager manager;
    private String name;
    private String location;
    // API
    /**
     * Constructs a new office with the given name, location and manager.
     * @param name - the name of the office
     * @param location - the location of the office
     * @param manager - the manager of the office
     */
    public Office(String name, String location, Manager manager) {
        this.name = name;
        this.location = location;
        this.manager = manager;
    }

    // Getters
    /**
     * Returns the name of the office.
     * @return - the name of the office.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Returns the location of the office.
     * @return - the location of the office.
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Returns the manager of the office.
     * @return - the manager of the office.
     */
    public Manager getManager() {
        return this.manager;
    }

    // Q8
    /**
     * Returns the direct manager of the given worker.
     * @param worker - the worker to find his manager
     * @return the direct manager of the given worker.
     */
    public Manager getWorkersManager(Worker worker) {
        // TODO: implement this function
    }

    // Q9B
    /**
     * Adds the given worker to the given manager.
     * @param worker - the worker to add
     * @param manager - the manager to add the worker to (the workers new direct manager)
     * if the worker is already a worker of the office, do nothing.
     * if the manager is not a manager of the office, do nothing.
     */
    public void addWorkerToManager(Worker worker, Manager manager) {
        // TODO: implement this function
    }

    // Q10B
    /**
     * Removes the given worker from the given manager.
     * if the worker is not a worker of the office, do nothing.
     * if the manager is not a manager of the office, do nothing.
     * @param worker - the worker to remove
     */
    public void removeWorkerFromManager(Worker worker) {
        // TODO: implement this function
    }

    // Q11
    /**
     * Returns the total salaries of all the workers in the office.
     * @return the total salaries of all the workers in the office.
     */
    public long getTotalSalaries() {
        // TODO: implement this function
    }

    // Q12
    /**
     * moves the given worker from his current manager to the given manager.
     * @param worker - the worker to move
     * @param newManager - the new manager of the worker
     */
    public void moveWorkerBetweenManagers(Worker worker, Manager newManager){
        // TODO: implement this function
    }
}
