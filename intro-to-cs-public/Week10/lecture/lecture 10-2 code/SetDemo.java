public class SetDemo {

	public static void main(String args[]) {
		Set s1 = new Set();
		s1.add(3); s1.add(1); s1.add(3); s1.add(5); s1.add(7);  
		System.out.println("\ns1 = " + s1);

		int[] data = {7, 9, 1, 9, 1, 7};
		Set s2 = new Set(data);
		System.out.println("s2 = " + s2);	

		//Set s3 = new Set(s2);
        //System.out.println("s3 = " + s3);	
	    
		System.out.println("\nUnion of s1 and s2 = " + s1.union(s2));	
		System.out.println("Intersection of s1 and s2 = " + s1.intersection(s2));	
	}
}
