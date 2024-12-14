public class ProblemSet2Sol {

    public static void main(String[] args) {
        
        // 1. If statement
        // Write an if-else statement that checks if a number is positive, negative, or zero.
        // Print "Positive", "Negative", or "Zero" based on the condition.
        
        int number = -5;
        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }

        // 2. Nested if statements
        // Write a program that checks if a person is eligible to vote.
        // A person is eligible if they are 18 or older and a citizen.
        
        int age = 20;
        boolean isCitizen = true;
        if (isCitizen) {
            if (age >= 18) {
                System.out.println("Eligible to vote");
            }
        } else {
            System.out.println("Not eligible to vote");
        }

        // 3. Switch statement
        // Write a switch statement that prints the name of a day based on a given integer (1-7).
        // For example, 1 = "Sunday", 2 = "Monday", ..., 7 = "Saturday".
        
        int dayOfWeek = 3;
        switch (dayOfWeek) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid day");
        }

        // 4. For loop
        // Write a for loop that prints all even numbers between 1 and 10.
        
        for (int i = 2; i < 10; i = i + 2) {
            System.out.println(i);
        }

        // 5. Nested for loops
        // Write a nested for loop to print a multiplication table for numbers 1 through 5.
        
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print( i * j + " ");
            }
            System.out.println();
        }

        // 6. While loop
        // Write a while loop that prints the numbers from 1 to 5.
        
        int counter = 1;
        while (counter < 6) {
            System.out.println(counter);
            counter++;
        }

        // 7. Do-while loop
        // Write a do-while loop that samples a random number between 1 to 10.
        // The loop should continue until the number 7 is sampled.
        
        int guess;
        do {
            // Simulate user input
            guess = (int)(Math.random() * 10) + 1;
            System.out.println("Random Number: " + guess);
        } while (guess != 7);

        // 8. Convert decimal to binary
        // Write a program that converts an integer to its binary representation using a loop.
        // Example: If the input is 5, the output should be "101".
        
        int decimal = 19;
        String binary = "";
        while (decimal != 0) {
            int remainder = decimal % 2;
            binary = remainder + binary;
            decimal = decimal / 2;
        }
        System.out.println("Binary: " + binary);

        // 9. For loop
        // Write a for loop that calculates the sum of all elements which are divisible by 3 up to 50.
        
        int sum = 0;
        for (int i = 0; i < 50; i++) {
            if (i % 3 == 0) {
                sum += i;
            }
        }
        System.out.println("Sum: " + sum);

        // 10. Using break in a loop
        // Write a for loop that prints numbers from 1 to 10, but stops if it encounters the number 5.
        
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println(i);
        }
    }
}