import java.util.HashMap;

public class MapDemo {

	private static HashMap<String , List> map = new HashMap<String , List>();

	// Adds the given word and all its letters to the map.
	// Constructs a list of all the letters in the word, 
	// and adds the word and the list to the map.
	public static void AddToMap(String word) {
		List letters = new List();
		for(int i = 0; i < word.length(); i++) {
			letters.addLast(word.charAt(i));
		}
		map.put(word, letters);
	}
	
	// If the given word is in the list, returns an array containing all its letters.
	// if the given word is not in the list, returns null.
	public static char[] letters(String word) {		
	    List list = map.get(word);
		if (list != null) {
		    return list.toArray();
		}
		return null;
	}
	
	// Prints all the elements in the map, in the following format:
	// word: (l1, l2, l3, ...) Where the l's are the letters in the word.
	// For example:
	// food: (f, o, o, d)
	// chair: (c, h, a, i, r)
	// ...
	public static void print() {
		for(String key : map.keySet()) {
			List letters = map.get(key);
			System.out.print(key + ": (");
			for(int i = 0; i < letters.getSize(); i++) {
				System.out.print(letters.get(i));
				
				if (i < letters.getSize() - 1) {
				    System.out.print(", ");
				}
			}
			System.out.print(" )");
			System.out.println();
		}
	}
	
	// LETS TALK ABOUT THIS METHOD
	// Returns a list of all the letters in the map from all the values list
	//The order and duplicates doesn't matter
	public static List allLetters() {
		List all_values = new List();
		for(List value : map.values()) {
			ListIterator iterator = value.listIterator(0);
			
			while(iterator.hasNext())
				all_values.addFirst(iterator.next());
		}
		
		return all_values;
	}
	
	
	public static void main(String[] args) {
		
		String word1 = "food";
		String word2 = "chair";
		String word3 = "car";
		
		AddToMap(word1);
		AddToMap(word2);
		AddToMap(word3);
		char[] arr1 = letters(word1);
		char[] arr2 = letters(word2);
		char[] arr3 = letters(word3);
		char[] arr4 = letters("gdgdd");
		
		for(int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " , ");
		}
		
		System.out.println();
		
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " , ");
		}
		
		System.out.println();
		
		for(int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " , ");
		}
		System.out.println();

		if(arr4 == null)
			System.out.println("this name isn't in the HashMap");
		System.out.println();
		
		print();
		
		List list = allLetters();
		for(int i = 0; i < list.getSize(); i++) {
			System.out.print(list.get(i) + " , ");
		}
	}

}
