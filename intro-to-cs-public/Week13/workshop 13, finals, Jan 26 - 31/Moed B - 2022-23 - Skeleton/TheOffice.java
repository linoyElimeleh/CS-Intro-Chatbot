// This class was created by Intro to Computer Science staff 2022 - 2023 at Reichman University
// was used for finals moed B 2022-2023
// was given as API to be used in the exam (no need to implement it)
// Implementation wasn't shown in the exam
// implemented by: Tal Danai, position: Recitation TA
public class TheOffice {
    public static void main(String[] args) {
        Manager michael = new Manager("Michael Scott", 150000);
        Worker dwight = new Worker("Dwight Schrute", 80000);
        Manager jim = new Manager("Jim Halpert", 80000);
        Worker pam = new Worker("Pam Beesly", 60000);
        Manager angela = new Manager("Angela Martin", 100000);
        Worker kevin = new Worker("Kevin Malone", 60000);
        Worker stanley = new Worker("Stanley Hudson", 60000);
        Worker creed = new Worker("Creed Bratton", 60000);
        Worker oscar = new Worker("Oscar Martinez", 60000);
        Worker phyllis = new Worker("Phyllis Lapin", 60000);
        Worker andy = new Worker("Andy Bernard", 60000);
        Worker erin = new Worker("Erin Hannon", 60000);
        Manager kelly = new Manager("Kelly Kapoor", 60000);
        Manager darryl = new Manager("Darryl Philbin", 60000);
        Worker toby = new Worker("Toby Flenderson", 60000);
        Worker holly = new Worker("Holly Flax", 60000);
        Manager jan = new Manager("Jan Levinson", 60000);
        Worker roy = new Worker("Roy Anderson", 60000);
        Worker ryan = new Worker("Ryan Howard", 60000);
        Manager karen = new Manager("Karen Filippelli", 60000);
        Worker intern = new Worker("Intern", 1);
        Worker intern2 = new Worker("Intern2", 1);

        
        michael.addWorker(dwight);
        michael.addWorker(jim);
        michael.addWorker(pam);
        michael.addWorker(angela);
        michael.addWorker(stanley);
        michael.addWorker(creed);
        michael.addWorker(phyllis);
        michael.addWorker(andy);
        michael.addWorker(erin);
        michael.addWorker(kelly);
        michael.addWorker(darryl);
        michael.addWorker(toby);
        michael.addWorker(holly);
        michael.addWorker(ryan);
        angela.addWorker(kevin);
        darryl.addWorker(roy);
        jim.addWorker(karen);
        karen.addWorker(intern);

        Office office = new Office("Dunder Mifflin", "Scranton, PA", michael);
        System.out.println("\nPrints Q8\n");
        System.out.println(office.getWorkersManager(ryan));
        System.out.println(office.getWorkersManager(roy));
        System.out.println(office.getWorkersManager(kevin));
        System.out.println(office.getWorkersManager(intern));
        System.out.println(office.getWorkersManager(jan));


        System.out.println("\nPrints Q9\n");
        System.out.println(angela.hasWorker(oscar));
        office.addWorkerToManager(oscar, angela);
        System.out.println(angela.hasWorker(oscar));

        System.out.println(karen.hasWorker(intern2));
        System.out.println(jim.hasWorker(intern2));

        office.addWorkerToManager(intern2, karen);

        System.out.println(karen.hasWorker(intern2));
        System.out.println(jim.hasWorker(intern2));
        System.out.println("\nPrints Q10\n");
        System.out.println(karen.hasWorker(intern2));
        System.out.println(jim.hasWorker(intern2));
        office.removeWorkerFromManager(intern2);
        System.out.println(karen.hasWorker(intern2));
        System.out.println(jim.hasWorker(intern2));

        System.out.println("\nPrints Q11\n");
        System.out.println(office.getTotalSalaries());
        
        System.out.println("\nPrints Q12\n");
        System.out.println(karen.hasWorker(intern));
        System.out.println(darryl.hasWorker(intern));
        office.moveWorkerBetweenManagers(intern, darryl);
        System.out.println(karen.hasWorker(intern));
        System.out.println(darryl.hasWorker(intern));

        System.out.println(michael.hasWorker(ryan));
        System.out.println(michael.getWorkers().contains(ryan));
        System.out.println(kelly.hasWorker(ryan));
        office.moveWorkerBetweenManagers(ryan, kelly);
        System.out.println(michael.hasWorker(ryan));// should be true since kelly is still a worker of michael
        System.out.println(michael.getWorkers().contains(ryan));// should be false since ryan is not directly under michael
        System.out.println(kelly.hasWorker(ryan));


    }
}
