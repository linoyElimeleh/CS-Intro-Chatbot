public class ClassInheritanceDemo {
    public static void main(String[] args) {
        demo1();
        //demo2();
    }

    private static void demo1() {
        Instructor socrates = new Instructor("Socrates", "Athens", "Prof.");
        Student ron = new Student("Ron", "Raanana", 1001, "Dance");
        System.out.println(socrates);
        System.out.println(ron);
        socrates.setAddress("Tel Aviv");
        System.out.println(socrates);
    }

    private static void demo2() {
        // Create a list of Person objects (polymorphism)
        Person[] people = new Person[] {
            new Instructor("Socrates", "Raanana", "Prof."),
            new Instructor("Feynman", "Tel Aviv", "Dr."),
            new Student("Ron", "Raanana", 1001, "Dance"),
            new Student("Neta", "Raanana", 1002, "Debate"),
            new Student("Avigail", "Tel Aviv", 1003, "Dance")
        };

        // Print roles and details
        for (Person person : people) {
            System.out.println(person);
        }

        // Call method to print persons from a specific city
        System.out.println("People from Raanana:");
        printPersonsFromCity(people, "Raanana");
    }

    /**
     * Prints all persons from the given city.
     * @param people Array of Person objects
     * @param city The city to filter by
     */
    public static void printPersonsFromCity(Person[] people, String city) {
        for (Person person : people) {
            if (person.address.equals(city)) { // Check if the address matches the city
                System.out.println(person);
            }
        }
    }
}
