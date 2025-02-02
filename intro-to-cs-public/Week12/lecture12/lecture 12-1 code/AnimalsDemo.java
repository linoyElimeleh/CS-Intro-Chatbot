// Tests the animal classes
public class AnimalsDemo {

    public static void main(String[] args) {
        //demo1();
        // demo2();
        demo3();
    }

    public static void demo1() {
    	Mouse m = new Mouse();
    	System.out.println(m.sound());

        Boa b1 = new Boa(m);
        System.out.println(b1.sound());

        Boa b2 = new Boa(b1);
        System.out.println(b2.sound());
    }

    public static void demo2() {
        Cow pua = new Cow(500);
        Dog puff = new Dog();

        System.out.println(pua.sound());      
        System.out.println(puff.sound()); 

        sounds(pua, 2);
        sounds(puff, 3); 
    }

    // Makes the sound of the given animal, n times
    private static void sounds(Animal a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(a.sound());
        }
    }

    public static void demo3() {
        // Makes an animals farm
        Animal[] farm = { new Cow(500), new Dog(), new Mouse() };
        // Produces the Old McDonald song for all the animals in the farm
        for (Animal animal : farm)
            oldMacDonaldVerse(animal);
    }

    private static void oldMacDonaldVerse(Animal animal) {
        String eieio = ", E-I-E-I-O";
        System.out.println("Old MacDonald had a farm" + eieio);
        System.out.println("And in this farm he had a " + animal.getClass().getName() + eieio);
        String sound = animal.sound();
        System.out.println("With a " + sound + " here and a " + sound + " there" );
        System.out.println( "Here a " + sound + " there a " + sound);
        System.out.println("Everywhere a " + sound + " " + sound);
        System.out.println("Old MacDonald had a farm" + eieio);
        System.out.println();
    }
}
