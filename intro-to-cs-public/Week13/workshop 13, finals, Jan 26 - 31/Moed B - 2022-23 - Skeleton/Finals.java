// This class was created by Intro to Computer Science staff 2022 - 2023 at Reichman University
// was used for finals moed B 2022-2023
// was given to be implemented in the exam
// Solution implemented by: Tal Danai, position: Recitation TA
public class Finals {
    
    //Q1
    /**
    Given a 2-dimentional array NxN named “mat” containing integers (positive, negative and zero), that fulfills the following conditions:
    a.	Every row is sorted in an increasing way (and there are no two identical numbers in each row)
    b.	Every column is sorted in an increasing way (and there are no two identical numbers in each column)
    Implement the function numOfNegativeNumbers whose input is a 2-dimnetional array mat as described above, that returns the number of negative numbers in the array.
    For example, for the following matrix the function will return 10.
    
    The required time complexity is linear O(N), where N is the dimension of the matrix. A solution with higher complexity will earn fewer points.
    */
    public static int numOfNegativeNumbers (int [][] mat){
        // TODO: implement this function
    }

    //Q2
    /**
     * write a recursive function whose input is a String str and an integer x, and that returns true if the first x characters in str are symmetric to the last x characters in str; false otherwise.
    For example:
    isSymmetric("abdgutyrgdba",4) // true
    isSymmetric("abdgutyrgdba",2) // true
    isSymmetric("abca",2) // false
    isSymmetric("aaa",2) // true
    isSymmetric("aaaa",5) // false
    */  
    public static boolean isSymmetricX(String str, int x){
        // TODO: implement this function
    }
    
    //Q3
    // An integer bigger than 1 will be called k-almost prime if it is composed of exactly k prime factors.
    // For example:
    // The number 14 is 2-almost prime since it's composed of 2 prime factors: 2*7
    // The number 13 is 1-almost prime since it's composed of 1 prime factor: 13
    // The number 100 is 4-almost prime since it's composed of 4 prime numbers: 5*5*2*2
    // Implement the kAlmostPrime function (int n, int k) where n>1 k>0. The function returns true if n is a k-almost prime, false otherwise.

    public static boolean kAlmostPrime(int n, int k){
        // TODO: implement this function
    }

}
