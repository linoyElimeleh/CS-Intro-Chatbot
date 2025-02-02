public class ClassInheritanceDemo {
    public static void main(String[] args) {
        // demo1();
        demo2();
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
        // Creates some persons
        Person[] persons = new Person[] {
            new Instructor("Socrates", "Raanana", "Prof."),
            new Instructor("Feynman", "Tel Aviv", "Dr."),
            new Student("Ron", "Raanana", 1001, "Dance"),
            new Student("Neta", "Raanana", 1002, "Debate"),
            new Student("Avigail", "Tel Aviv", 1003, "Dance")
        };

        // Prints all persons
        for (Person person : persons) {
            System.out.println(person);
        }

        // Prints all persons from Raanana
        printPersonsFromCity(persons, "Raanana");
    }

    /** Prints all the persons from the given city. */
    public static void printPersonsFromCity(Person[] persons, String city) {
        for (Person person : persons) {
            if (person.address.equals(city)) {
                System.out.println(person);
            }
        }
    }
}
