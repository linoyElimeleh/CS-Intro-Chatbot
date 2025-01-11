public class SetDemo {
	public static void main(String args[]) {
		Set s1 = new Set();
		s1.add(3); s1.add(1); s1.add(3); s1.add(7); s1.add(5); 
		System.out.println("\ns1 = " + s1);

		int[] data = {7, 1, 7, 8, 1, 7};
		Set s2 = new Set(data);
		System.out.println("s2 = " + s2);	
		
		System.out.println("\nIntersection of s1 and s2 = " + s1.intersection(s2));
		System.out.println("Union of s1 and s2 = " + s1.union(s2));		

		s2.remove(1);
		System.out.println("\ns2 after removing 1 = " + s2);
		s2.remove(8);
		System.out.println("s2 after removing 8 = " + s2);
		s2.remove(7);
        System.out.println("s2 after removing 7 = " + s2); 
	}
}
