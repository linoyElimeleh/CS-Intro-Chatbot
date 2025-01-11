public class Examples {

    public static void main(String[] args) {
    	int[] arr1 = { 0, 1, 2, 3, 4, 5, 6, 7 };
    	int[] arr2 = { 6, 4, 2, 1 };
    	System.out.println(contains(3, arr1));
    	System.out.println(contains(12, arr1));
    	System.out.println(subsetOf(arr2, arr1));
    	System.out.println(subsetOf(arr1, arr2));
    }

    // Checks if the given array contains the given value
	public static boolean contains (int x, int[] a) {
	   for (int i = 0; i < a.length; i++) {
	      if (a[i] == x) {
	         return true;
	      }
	   }
	   return false;
	}
}
