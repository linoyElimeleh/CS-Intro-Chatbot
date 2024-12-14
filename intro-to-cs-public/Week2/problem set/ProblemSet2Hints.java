public class ProblemSet2Hints {

    public static void main(String[] args) {
        
        // 1. If statement
        // Write an if-else statement that checks if a number is positive, negative, or zero.
        // Print "Positive", "Negative", or "Zero" based on the condition.
        
        int number = -5;
        if (?) {
            System.out.println("Positive");
        } else if (?) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }

        // 2. Nested if statements
        // Write a program that checks if a person is eligible to vote.
        // A person is eligible if they are 18 or older and a citizen.
        
        int age = 20;
        boolean isCitizen = true;
        if (?) {
            if (?) {
                System.out.println("Eligible to vote");
            }
        } else {
            System.out.println("Not eligible to vote");
        }

        // 3. Switch statement
        // Write a switch statement that prints the name of a day based on a given integer (1-7).
        // For example, 1 = "Sunday", 2 = "Monday", ..., 7 = "Saturday".
        
        int dayOfWeek = 3;
        switch (?) {
            case ?:
                System.out.println("Sunday");
                break;
            case ?:
                System.out.println("Monday");
                break;
            case ?:
                System.out.println("Tuesday");
                break;
            case ?:
                System.out.println("Wednesday");
                break;
            case ?:
                System.out.println("Thursday");
                break;
            case ?:
                System.out.println("Friday");
                break;
            case ?:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid day");
        }

        // 4. For loop
        // Write a for loop that prints all even numbers between 1 and 10.
        
        for (?) {
            System.out.println(i);
        }

        // 5. Nested for loops
        // Write a nested for loop to print a multiplication table for numbers 1 through 5.
        
        for (int i = ?; i <= ?; i++) {
            for (int j = ?; j <= ?; j++) {
                System.out.print( ? + " ");
            }
            System.out.println();
        }

        // 6. While loop
        // Write a while loop that prints the numbers from 1 to 5.
        
        int counter = 1;
        while (?) {
            System.out.println(counter);
            counter++;
        }

        // 7. Do-while loop
        // Write a do-while loop that asks the user to guess a number between 1 and 10.
        // The loop should continue until the user guesses the correct number (assume the correct number is 7).
        
        int guess = 0;
        do {
            // Simulate user input (you can later replace it with actual input using Scanner)
            guess = (int)(Math.random() * ?) + 1;
            System.out.println("Guess: " + guess);
        } while (?);

        // 8. Convert decimal to binary
        // Write a program that converts an integer to its binary representation using a loop.
        // Example: If the input is 5, the output should be "101".
        
        int decimal = 19;
        String binary = "";
        while (?) {
            int remainder = decimal % ?;
            binary = remainder + binary;
            decimal = decimal / ?;
        }
        System.out.println("Binary: " + binary);

        // 9. For loop
        // Write a for loop that calculates the sum of all elements which are divisible by 3 up to 50.
        
        int sum = 0;
        for (int i = ?; i < ?; i++) {
            if (i % ? == 0) {
                sum += ?;
            }
        }
        System.out.println("Sum: " + sum);

        // 10. Using break in a loop
        // Write a for loop that prints numbers from 1 to 10, but stops if it encounters the number 5.
        
        for (int i = ?; i <= ?; ?) {
            if (?) {
                break;
            }
            System.out.println(?);
        }
    }
}