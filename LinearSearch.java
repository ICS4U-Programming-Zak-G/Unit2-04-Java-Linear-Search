// Import libraries
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

/** .
* This program generates a line of 10 random integers
* between 0-100.
* They are then sorted and the user inputs a number.
* A linear search is then performed to see if it is in the array.
*
* @author  Zak Goneau
* @version 1.0
* @since   2025-03-20
*/

// Creating class
public final class LinearSearch {

    // Declare constants

    /** .
     * MAX is the highest the random integers can go.
     */
    private static final int MAX = 99;

    /** .
     * MIN is the lowest the random integers can go.
     */
    private static final int MIN = 1;

    /** .
     * MAX_SIZE is the max size of the array.
     */
    private static final int MAX_SIZE = 10;

    /**
     * This is a private constructor used to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private LinearSearch() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        // Initialize variables
        int randNumber = 0;
        String userInput = "";
        int userNum = 0;

        // Introduce program to user
        System.out.println("This generates a line of random numbers\n"
                + "having 10 integers. Input a number and \n"
                + "the index it is found will be displayed.\n");

        // Create instance of random class
        Random rand = new Random();

        // Create scanner class
        final Scanner scanner = new Scanner(System.in);

        // Create array
        int[] arrayNum = new int[MAX_SIZE];

        // Loop process until user quits
        while (userInput != "q") {

            // Loop and populate array with random numbers until full
            for (int counter = 0; counter < MAX_SIZE; counter++) {

                // Get random number between 0-100
                randNumber = rand.nextInt(MAX - MIN + 1) + MIN;

                // Populate array with random numbers
                arrayNum[counter] = randNumber;
            }

            // Sort array
            Arrays.sort(arrayNum);

            // Print array using for loop
            for (int arrayCounter = 0; arrayCounter < MAX_SIZE;
                 arrayCounter++) {
                System.out.print(arrayNum[arrayCounter] + " ");
            }

            // Get user input
            System.out.print("Please enter a number: ");
            userInput = scanner.nextLine();

            // Break if input is q
            if (userInput.equals("q")) {
                break;
            }

            // Initialize index value to -1
            int indexValue = -1;

            // Try to convert input from string to integer
            try {
                userNum = Integer.parseInt(userInput);

                // Scan through array to find number
                for (int indexCounter = 0; indexCounter < MAX_SIZE;
                     indexCounter++) {
                    // Check if number is in array
                    if (userNum == arrayNum[indexCounter]) {

                        // Change index value
                        indexValue = indexCounter;

                        // Break from loop
                        break;
                    }
                }

                // Print results to user
                if (indexValue == -1) {
                    System.out.println(userNum + " isn't in the array.");
                } else {
                    System.out.println("Your number is at index " + indexValue);
                }

                // Catch invalid inputs
            } catch (NumberFormatException error) {
                System.out.println("Please enter a number. "
                        + error.getMessage());
            }
        }
        // Thank user for playing
        System.out.println("Thank you for playing!");

        // Close scanner
        scanner.close();
    }
}
