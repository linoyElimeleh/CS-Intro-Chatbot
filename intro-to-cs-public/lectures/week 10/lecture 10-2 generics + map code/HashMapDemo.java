import java.util.HashMap;

/** Map demo, used Java's generic HashMap class. */
public class HashMapDemo {

	public static void main(String args[]) {
		HashMap<String,String> animalSounds = new HashMap<String,String>();
		animalSounds.put("dog", "woof");
		animalSounds.put("cat", "miao");
		animalSounds.put("cow", "moo");
		animalSounds.put("mouse", "squeak");
		System.out.println("Cow goes " + animalSounds.get("cow"));
		System.out.println("Mouse goes " + animalSounds.get("mouse"));
		for (String sound: animalSounds.values()) {
			System.out.println(sound);
		}
	}
}
