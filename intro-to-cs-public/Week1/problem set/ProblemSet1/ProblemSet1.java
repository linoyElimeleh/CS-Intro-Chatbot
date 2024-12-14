public class ProblemSet1 {

    public static void main(String[] args) {
        
        // 1. Variables and types
        // Declare two variables: an integer called "age" and a double called "height".
        // Initialize them with your age and height in meters.
        
        // Put your code here

        System.err.println("My height is " + height + " and I am " + age + " years old");

        // 2. Mathematical operations
        // Calculate the area of a circle with a radius of 7 using the Math.PI constant and Math.pow function.
        // Store the result in a double variable called "circleArea" and print it.
        
        // Put your code here

        System.out.println("Circle Area: " + circleArea);

        // 3. Boolean logic
        // Create two boolean variables, "isRaining" and "hasUmbrella". 
        // Use a boolean expression to check if you should stay dry (true if it's raining and you have an umbrella).
        
        // Put your code here

        System.out.println("Stay Dry: " + stayDry);

        // 4. Type casting
        // Create a double variable "temperatureCelsius" and convert it to an integer value called "temperatureRounded".
        // Print both the original and the rounded temperature values.
        
        // Put your code here

        System.out.println("Original temperature: " + temperatureCelsius);
        System.out.println("Rounded temperature: " + temperatureRounded);

        // 5. Arithmetic with casting
        // Declare two integer variables, "num1" and "num2", and divide num1 by num2.
        // Store the result as a double by casting one of the integers and print the result.
        
        // Put your code here
        
        System.out.println("Division result: " + divisionResult);

        // 6. Math Operations
        // Given a "Right" triangle's legs a, b, calculate the size of its hypotenuse and store it in a 'double' type variable named 'hypotenuse'. 
        
        double legA = 3;
        double legB = 4;

        // Put your code here
        
        System.out.println("Triangle Legs: a: " + legA + " b: " + legB + "; Hypotenuse: " + hypotenuse);

        // 7. Math and boolean
        // Use Math.random() to generate a random number between 0 and 1.
        // Declare a boolean value which holds "True" if the value is greater than 0.5.
        // Suggestion: After compilation run the program a few times to see how the result changes.

        // Put your code here
        
        System.out.println("My random Value is: " + randomNumber + ". Greater than 0.5: " + isGreaterThanHalf);

        // 8. Type conversion between primitives
        // Declare a float variable "heightInMeters" and initialize it with a value.
        // Convert it to an integer, storing the result in a new variable called "heightInCM" (centimeters).
        // Print both values.
        
        // Put your code here
        
        System.out.println("Height in meters: " + heightInMeters);
        System.out.println("Height in centimeters: " + heightInCM);

        // 9. Using Math with casting
        // Calculate the square root of 25 using the Math.sqrt method, then cast the result to an integer and print it.
        
        // Put your code here
        
        System.out.println("Integer square root: " + intSquareRoot);

        // 10. Boolean expression with Math
        // Check if the absolute difference between two numbers is greater than 10.
        // Use Math.abs and print true or false based on the condition.
        
        int a = 25;
        int b = 40;

        // Put your code here
        
        System.out.println("Difference greater than 10: " + isDiffGreaterThan10);
    }
}