import java.util.HashMap;

/** Map demo, used Java's generic HashMap class. */
public class HashMapDemo {

	public static void main(String args[]) {
		HashMap<String,String> animalSound = new HashMap<String,String>();
		animalSound.put("dog", "woof");
		animalSound.put("cat", "miao");
		animalSound.put("cow", "moo");
		animalSound.put("mouse", "squeak");
		System.out.println("Cow goes " + animalSound.get("cow"));
		System.out.println("Mouse goes " + animalSound.get("mouse"));
		
		System.out.println(animalSound.values());

		// Iterates over the animals in the map;
        // For each animal, prints the animal and its sound.
		for (String animal : animalSound.keySet()) {
    		String sound = animalSound.get(animal);
    		System.out.println(animal + " goes " + sound);
		}
	}
}
