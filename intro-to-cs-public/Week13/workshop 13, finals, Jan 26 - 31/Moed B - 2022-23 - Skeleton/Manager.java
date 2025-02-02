// This class was created by Intro to Computer Science staff 2022 - 2023 at Reichman University
// was used for finals moed B 2022-2023
// was given as API and some were needed to solved as part of the test
// Implementation wasn't shown in the exam
// implemented by: Tal Danai, position: Recitation TA
public class Manager extends Worker {  
    private LinkedList<Worker> workers;
    
    /**
     * Constructs a new manager with the given name and salary.
     * @param name - the name of the manager
     * @param salary - the salary of the manager
     */
    public Manager (String name, int salary){
        super(name, salary);
        this.workers = new LinkedList<Worker>();
    }

    /**
     * Returns the list of workers of this manager.
     * @return the list of workers of this manager.
     */
    public LinkedList<Worker> getWorkers(){
        return this.workers;
    }

    /**
     * Returns the array of workers of this manager.
     * @return the array of workers of this manager.
     */
    public Worker[] toArray(){
        if (this.workers.size() == 0){
            return new Worker[0];
        }
        Worker [] workerArray = new Worker [this.workers.size() - 1];
        ListIterator <Worker> it = this.workers.iterator();
        for (int i = 0; i < workerArray.length; i++) {
            workerArray[i] = it.next();
        }
        return workerArray;
    }


    /**
     * Returns true if this manager is a manager, false otherwise.
     * @return true if this manager is a manager, false otherwise.
     */
    public boolean isManager(){
        return true;
    }
    
  
    /**
     * Checks if the given worker is a worker of this manager or one of his sub-managers.
     * @param worker - the worker to check
     * @return true if the given worker is a worker of this manager or one of his sub-managers, false otherwise.
     */
    public boolean hasWorker (Worker worker){
        if (worker == null){
            throw new IllegalArgumentException();
        }
        if (this.workers.contains(worker)){
            return true;
        }
        for (Worker w : this.toArray()){
            if (w.isManager()){
                if (((Manager)w).hasWorker(worker)){
                    return true;
                }
            }
        }
        return false;
    }

    // Q5
    /**
     * Constructs a new manager with the given name, salary and workers.
     * The workers are added to the list of workers of this manager.
     * @param name - the name of the manager
     * @param salary - the salary of the manager
     * @param workers - the workers to add to the list of workers of this manager
     */
    public Manager (String name, int salary, Worker[] workers){
        // TODO: implement this function
    }

    // Q6
    /**
     * Returns the total salaries of this manager and his workers.
     * If a worker is a manager, his total salaries are also included.
     * @return the total salaries of this manager and his workers.
     */
    public long getTotalSalaries(){
        // TODO: implement this function
    }

   
    // Q7
    /** 
     * Returns true if the given object is a manager with the same name, salary and workers as this manager.
     * @param obj - the object to compare
     * @return true if the given object is a manager with the same name, salary and workers as this manager.
     * @Override
     */
    public boolean equals(Object obj){
        // TODO: implement this function
    }


    private static boolean compWorkers(Manager self, Manager other){
        // TODO: implement this function (should be helper of equals)
    }

    // Q9A
    /**
     * Adds the given worker to the list of workers of this manager.
     * In lexicographic order of the names of the workers.
     * @param worker
     */
    public void addWorker(Worker worker){
        // TODO: implement this function
    }

    /**
     * Q10A
     * Removes the given worker from the list of workers of this manager.
     * @param worker - the worker to remove
     */
    public void removeWorker(Worker worker){
        // TODO: implement this function
    }
    

}
