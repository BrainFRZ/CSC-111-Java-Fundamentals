/**************************************************************************************************
 * Program Name:     Program #4: Dice Roller
 * Author:           Terry Weiss
 * Date Written:     November 17, 2015
 * Course/Section:   CSC 111-003W
 * Program Description:
 *    This program manages a six-sided die.
 **************************************************************************************************/

import java.util.Random;

/**
 *
 * @author Terry
 */
public class Die {
    private static final Random generator = new Random();   //Psuedo-random integer Generator
    private static final int DIE_SIDES = 6;                 //Number of sides on each Die



    // Die Constructor
    /*
     * Constructs a stateless Die.
     */
    public Die() { } //empty Constructor


    // Roll the Die
    /*
     * Method Name: roll
     * Author: Terry Weiss
     * Date Written: November 10, 2015
     * Method Description:
     *   Rolls a Die of the default number of sides.
     *
     * Method Refined Algorithm:
     *  Generate a number within the default number of die sides
     *  Add 1 to the generated number to keep within the range of 1 - Sides
     */
    public static int roll() {
        return (generator.nextInt(DIE_SIDES) + 1);
    } //end method roll


    // Dice Adder
    /*
     * Method Name: sum
     * Author: Terry Weiss
     * Date Written: November 10, 2015
     * Method Description:
     *   Calculates the sum of two dice.
     *
     * Method Refined Algorithm:
     *  Get face value of both dice
     *  Add values together and output
     */
    public static int sum(int first, int second) {
        return (first + second);
    } //end method sum

    // Determines if doubles were rolled
    /*
     * Method Name: isDoubles
     * Author: Terry Weiss
     * Date Written: November 10, 2015
     * Method Description:
     *   Determines if the face value of two dice is equal.
     *
     * Method Refined Algorithm:
     *  Get face value of both dice
     *  Output if they're equal
     */
    public static boolean isDoubles(int first, int second) {
        return (first == second);
    } //end method isDoubles

    // Value Getter
    /*
     * Method Name: faceValue
     * Author: Terry Weiss
     * Date Written: November 10, 2015
     * Method Description:
     *   Gets face value if doubles are rolled.
     *
     * Method Refined Algorithm:
     *  Get face value of both dice
     *  Initialize value to 0
     *  IF first EQUALS second THEN
     *      Set value to a die face
     *  END IF
     *  Return value
     */
    public static int faceValue(int first, int second) {
        int value = 0;

        if (isDoubles(first, second)) {
            value = first;
        } //end if doubles

        return value;
    } //end method faceValue



    // String Representation
    /*
     * Method Name: toString
     * Author: Terry Weiss
     * Date Written: November 10, 2015
     * Method Description:
     *   Represents a new Die object's new roll as a String.
     *
     * Method Refined Algorithm:
     *   Output value of new roll as a String
     */
    @Override
    public String toString() {
        return Integer.toString(roll());
    } //end method toString
} //end class Die
