/*
This workshop file was written by Daniel Eitan (daniel.eitan@post.idc.ac.il)

GENERAL NOTE (for instructors) about comments in this file:
-------------------------------------------------------------------------------------------------------------------
I wrote several types of comments:
1."//":										output comment
2."///":									commented code
2.more slashes (e.g. "////////":			this comment is followed by a previous comment
3."//DISCUSS:":								intended for you to discuss with students
4."//DISCUSS?:":							intended for you to optionally discuss with students (if time permits, advanced students, etc ..)
5."//ONLY4U:":								intended for you only. not need to discuss with students
-------------------------------------------------------------------------------------------------------------------
*/


// Hey everyone,
// In this exercise we will deal with an one-dimensional arrays
// We have a single file (this one), functions will be added to it one by one, 
// and the main function should be adjusted accordingly.
// 1) we will implement function which prints an given array.
// 2) we will create a simple array
// 3) we will create an arithmetic serie
// 4) we will create an geometric array
// 5) we will create fibonacci serie
// 6) we wil remove vowels in a given string array
class WS4 {
    public static void main(String[] args) {
        // Here you should change functions call
    }

	// Given an array, print its content,
	// DISCUSS: note, you shouldn't use System.out.println(arr)
	//// use this function from this point on to print the generated arrays
	// ONLY4U: Make sure that spaces is being printed between elements
    public static void print(int[] arr) {
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

	// DISCUSS: The array should have the number i at index i
    public static int[] simple(int n) { // simple(5) will create the array {0,1,2,3,4}.
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

	
	// DISCUSS: Given two natural numbers, a and d, 
	//// we define an arithmetic sequence to be all numbers of the form a + i*d,
	//// where i is some natural number
	//// Examples:
	//// a = 0, d = 1:  The sequence we get is 0,1,2,3,4,5
	//// a = 2, d = 3:  The sequence we get is 2,5,8,11,14....
	//// mention that you can use previous element in order to compute current, as in following solution:
    public static int[] arithmetic(int n, int a, int d) {
        int[] arr = new int[n];
        arr[0] = a;
        for (int i = 1; i < n; i++) {
            // They will probably suggest: arr[i] = a + i*d
            arr[i] = arr[i-1] + d;
        }
        return arr;
    }
	
	
	// DISCUSS: Given two natural numbers, a and d, 
	//// we define an geometric sequence to be all numbers of the form a(i) = a(i-1)*q
	//// where i is some natural number
	//// Examples:
	//// a = 1, d = 2:  The sequence we get is 1,2,4,8,16,32
	//// a = 2, d = 3:  The sequence we get is 2,6,18,54,162....
	// DISCUSS: After revealing Arithmetic Sequence solution, 
	//// let them think what should be changed?......
	// ONLY4U: the only difference is arr[i] = arr[i-1] + q -> arr[i] = arr[i-1] * q;
    public static int[] geometric(int n, int a, int q) {
        int[] arr = new int[n];
        arr[0] = a;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i-1] * q;
        }
        return arr;
    }
	
	
	// DISCUSS:
	//// The Fibonacci sequence is defined the following way:
	//// a0 = 0
	//// a1 = 1
	//// And every other element of the sequence is defined as the sum of previous two.
	//// an = an-1 + an-2
	//// Example:
	//// 0, 1, 1, 2, 3, 5, 8, 13, 21..
	// DISCUSS: Let them think about the edge cases, what if n==1 || n==0
	// DISCUSS?: Only if you have time at the end of the workshop -- Worth mentioning Memoization:
	//// if number n already calculated, return it. otherwise, calculate from already calculated number untill n, and return.
	//// can save calculation time. Another concept is when arr exeeds its size we enlarge it be 2 (dynamic array)
	// ONLY4U: Note that FibonnaciWithMemoization prints all of its actions for better understanding 
	//// (calculating value from last calculated value (e.g calculating from 5 to 10), enlarging array, returning already calculated value) 
	// DISCUSS?: if time allows, and the end of the workshop, show then FibonnaciWithMemoization execution.
    public static int[] fibo (int n) {
        if (n == 0) {
            return new int[]{0};
        } else if (n == 1) {
            return new int[]{0,1};
        }

        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }

        return arr;
    }

	// A vowel is any of the letters {a,e,i,o,u}.
	// The function takes in an array of strings and remove the vowels in all of the strings.
	// DISCUSS: make sure they understand how to tackle this problen (hint: nested loop),
	//// suggest to have another function for checking if letter is vowel.
    public static String[] removeVowels (String[] args) {
		// Getting args
        String[] arr = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            arr[i] = args[i];
        }

        for (int i = 0; i < arr.length; i++) {
			String noVowels = "";
			for (int j = 0; j < arr[i].length(); j++) {
				if (!isVowel(arr[i].charAt(j))) {
					noVowels += arr[i].charAt(j);
				}
			}
			arr[i] = noVowels;
        }
		
		// Printing after processing
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
        return arr;
    }

	// Checking is vowel
    public static boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) > -1;
    }



     //DISCUS?: This section is only if you have an extra time or you want to let the student for having later themselves.
    public static double calculateSTD(int n) {
        double[] arr = new double[n];
        double sum = 0.0;
		double standardDeviation = 0.0;
        int length = arr.length;
        for(double num : arr) {
            sum += num;
        }

        double mean = sum/length;
        for(double num: arr) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
    }
}