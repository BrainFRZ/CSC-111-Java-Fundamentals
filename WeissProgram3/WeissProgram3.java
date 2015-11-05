/**************************************************************************************************
 * Program Name:     Program #3
 * Author:           Terry Weiss
 * Date Written:     November 10, 2015
 * Course/Section:   CSC 111-003W
 * Program Description:
 *    This program generates 20 random integers from 1 to 10, puts them in an array, and then
 * displays that array. Then a random number is generated, and the program counts how many times
 * that number is in the array. The user is allowed to create as many lists as they'd like.
 **************************************************************************************************/

import java.util.Random;
import java.util.Scanner;


/*
 *  This program generates 20 random numbers and prints them out. It then generates another random
 *  number and prints how many times it's in the list.
 *
 *  Input:
 *      (String) userContinues    - User's input as to whether they want to continue
 *  Output:
 *      (int[]) intArray        - List of random integers (size set by DEFAULT_ARRAY_SIZE)
 *      (int) randomNumber        - Random number that will be searched for in the list
 *      (int) count               - Number of instances of the random number in the array
 *  Additional Variables:
 *      (int) DEFAULT_ARRAY_SIZE  - Number of random integers allowed
 *      (int) MIN_INTEGER         - Minimum number allowed for the random generator
 *      (int) INTEGER_RANGE       - Size of the range for the random number generator
 *
 *  Initial Algorithm:
 *  DO
 *    Generate and display a list of random numbers between 1 and 10
 *    Generate and display another random number
 *    Count and display number of times the extra random number is in the list
 *  LOOP WHILE the User wants to continue
 */
public class WeissProgram3 {
    private static final int DEFAULT_ARRAY_SIZE = 20;  // Number of random integers allowed
    private static final int MIN_INTEGER = 1;     // Minimum number allowed for the random generator
    private static final int INTEGER_RANGE = 10;  // Size of the range for the random generator
    private static final Random generator = new Random(); // Random integer generator


    // Random number generator
    /*
     *  Method Name: randomInt
     *  Author: Terry Weiss
     *  Date Written: October 28, 2015
     *  Method Description:
     *    This method generates a random integer within the specified range, added to the specified
     *    shift value.
     *
     *  Method Refined Algorithm:
     *  Generate a number within the specified range
     *  Add the generated number to the shift value
     */
    private static int randomInt(int range, int shiftValue) {
        return generator.nextInt(range) + shiftValue;
    } //end method randomInt


    // Print number list
    /*
     *  Method name: printArray
     *  Author: Terry Weiss
     *  Date Written: October 28, 2015
     *  Method Description:
     *    This method prints each of the numbers in the specified array to the console.
     *
     *  Method Refined Algorithm:
     *  FOR index = 0 TO arraySize
     *    Print value of current array index
     *  NEXT index
     */
    private static void printArray(int[] array, int arraySize) {
        for(int index = 0; index < arraySize; index++) {
            System.out.printf("Number %2d: %d\n", (index + 1), array[index]);
        } //end for each index of array
    } //end method printArray


    // Search Array for Element
    /*
     *  Method Name: searchArray
     *  Author: Terry Weiss
     *  Date Written: November 10, 2015
     *  Method Description:
     *    This method searches the given array, and displays the number of instances of the given
     *  value in the array, or if it doesn't exist.
     *
     *  Method Refined Algorithm:
     *  Initialize count to 0
     *
     *  FOR index = 0 TO arraySize
     *    IF value of element at array index = element THEN
     *      Increment count
     *    END IF
     *  NEXT index
     *
     *  IF count > 0 THEN
     *    Display count
     *  ELSE
     *    Display that it doesn't exist
     *  END IF
     */
    public static void searchArray(int[] array, int arraySize, int element) {
        int count = 0; // Number of times the element exists in the array

        for (int index = 0; index < arraySize; index++) {
            if (array[index] == element) {
                count++;
            } //end if value of current array 
        } //end for each index of array

        if (count > 0) {
            String times = (count == 1) ? "time" : "times";  // Correct pluralization of "time"
            System.out.println(element + " is in the list " + count + " " + times + ".");
        }
        else {
            System.out.println(element + " isn't in the list.");
        }
    } //end method searchArray




    // Main entry point
    /*
     *  Method Name: main
     *  Author: Terry Weiss
     *  Date Written: November 10, 2015
     *  Method Description:
     *    This program generates 20 random integers from 1 to 10, puts them in an array, and then
     * displays that array. Then a random number is generated, and the program counts how many times
     * that number is in the array. The user is allowed to create as many lists as they'd like.
     *
     *  Method Refined Algorithm:
     *  Initialize new intArray to integer array of DEFAULT_ARRAY_SIZE
     *  DO
     *    FOR index = 0 TO intArray's length
     *      Set current index value to a random integer between MIN_INTEGER and MAX_INTEGER
     *    NEXT index
     *
     *    Print array of random integers
     *
     *    Generate a random number
     *    Display number of times random number exists in intArray
     *
     *    Prompt if User wants to continue
     *  LOOP WHILE User wants to continue
     */
    public static void main(String[] args) {
        /*
         *  Scanner instance capturing user's input from the console
         */
        final Scanner input = new Scanner(System.in);

        /*
         *  If the user wants to continue
         */
        String userContinues;

        /*
         *  List of random integers (size set by DEFAULT_ARRAY_SIZE)
         */
        final int[] intArray = new int[DEFAULT_ARRAY_SIZE];

        /*
         *  Random number that will be searched for in the list
         */
        int randomNumber;


        do { // while User wants to continue
            for(int index = 0; index < intArray.length; index++) {
                intArray[index] = randomInt(INTEGER_RANGE, MIN_INTEGER);
            } //end for each index


            System.out.println("List of " + intArray.length + " random numbers:");
            printArray(intArray, intArray.length);

            randomNumber = randomInt(INTEGER_RANGE, MIN_INTEGER);
            System.out.println("\nCounting " + randomNumber + "s in list...");

            searchArray(intArray, intArray.length, randomNumber);


            System.out.print("\nWould you like to generate another list? ");
            userContinues = input.next();
            System.out.println();
        } while(userContinues.equalsIgnoreCase("y") || userContinues.equalsIgnoreCase("yes"));
    } //end method main
} //end class WeissProgram3
