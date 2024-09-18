// Tests the animal classes
public class TestAnimals {

    public static void main(String args[]) {
    	Mouse m = new Mouse();
    	System.out.println(m.sound());

        Boa b1 = new Boa(m);
        System.out.println(b1.sound());

        Boa b2 = new Boa(b1);
        System.out.println(b2.sound());

        Animal[] farm = { new Cow(500), new Dog(), new Mouse() }; // put here any animal you want
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
