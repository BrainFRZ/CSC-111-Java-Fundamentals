/**************************************************************************************************
 *  Program Name:     Lab #9
 *  Author:           Terry Weiss
 *  Date Due:         November 3, 2015
 *  Course/Section:   CSC 111-003W
 *  Program Description:
 *     This program generates an array of 20 random integers between 1 and 10 and prints it to the
 *  console. The user will be able to continue to create new arrays until they decide to quit.
 **************************************************************************************************/

import java.util.Random;
import java.util.Scanner;

/*
 *  This class generates an array of 20 random integers between 1 and 10 and prints it to the
 *  console. The user will be able to continue to create new arrays until they decide to quit.
 *
 *  Initial algorithm:
 *  Until the User wants to stop:
 *    Create a list of 20 random integers
 *    Display list of integers
 *    Prompt if the user wants to make another list
 */
public class WeissLab9 {
    private static final int DEFAULT_ARRAY_SIZE = 20;  // Size of the array list to be filled
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




    // Main entry point
    /*
     *  Method Name: main
     *  Author: Terry Weiss
     *  Date Written: October 28, 2015
     *  Method Description:
     *    This program generates an array of 20 random integers between 1 and 10 and prints it to
     *    the console. The user will be able to continue to create new arrays until they decide to
     *    quit.
     *
     *  Method Refined Algorithm:
     *  DO
     *    Initialize new intArray to DEFAULT_ARRAY_SIZE
     *    FOR index = 0 TO intArray's length
     *      Set current index value to a random integer between MIN_INTEGER and MAX_INTEGER
     *    NEXT index
     *
     *    Print array of random integers
     *
     *    Prompt if User wants to continue
     *  LOOP WHILE User wants to continue
     */
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        int[] intArray = new int[DEFAULT_ARRAY_SIZE];
        String userContinues;

        do { //while User wants to continue
            for(int index = 0; index < intArray.length; index++) {
                intArray[index] = randomInt(INTEGER_RANGE, MIN_INTEGER);
            } //end for each index

            printArray(intArray, intArray.length);

            System.out.print("Would you like to generate another list? ");
            userContinues = user_input.next();
        } while(userContinues.equalsIgnoreCase("y") || userContinues.equalsIgnoreCase("yes"));
    } //end method main
} //end class WeissLab9
