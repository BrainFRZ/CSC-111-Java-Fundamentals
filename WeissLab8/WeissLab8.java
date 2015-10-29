/**************************************************************************************************
 * Program Name:     Lab #8
 * Author:           Terry Weiss
 * Date Written:     October 27, 2015
 * Course/Section:   CSC 111-003W
 * Program Description:
 *    This program uses a for-loop to prompt the User for 10 letters into an array, and then prints
 * them back out.
 **************************************************************************************************/

import java.util.Scanner;

/*
 * This program prompts the User for 10 letters. It stores them in an array, and then prints them
 * back out.
 *
 * Input:
 *     (String) letter – The letter entered
 * Output:
 *     (String) letter – The letter entered
 * Additional Variables:
 *     (int) LETTERS – The number of letters that will be prompted for
 *     (String) letterArray – The array holding the letters
 *     (String) literalNth – An array naming the position of each letter ("first", "second", etc)
 *     (int) counter – The position in the array
 *
 * Initial Algorithm:
 * For each letter, until the user has entered 10 letters:
 *     Prompt for a letter, until it is a valid letter
 *     Store the letter in an array
 * For each letter in the array:
 *     Display the letter
 */
public class WeissLab8
{
    /*
     * This method uses a for-loop to prompt the User for 10 letters. It stores them in an array,
     * and then prints them back out using a second for-loop.
     *
     * Refined Algorithm:
     * FOR counter = 0 TO 9
     *     DO
     *         Prompt for a letter
     *
     *         IF letter isn't valid THEN
     *             Display error code
     *         END IF
     *     LOOP WHILE letter isn’t 1 character OR letter isn’t a valid letter
     *
     *     Save letter to letterArray
     * NEXT counter
     *
     * FOR counter = 0 TO 9
     *     Display the current letter from letteryArray
     * NEXT counter
     */
    public static void main( String[] args )
    {
        /*
         * The number of letters that will be prompted for.
         */
        final int LETTERS = 10;

        /*
         * Object storing the user's input.
         */
        Scanner user_input = new Scanner(System.in);

        /*
         * The letter entered.
         */
        String letter;

        /*
         * Holds the letters provided by the User.
         */
        String[] letterArray = new String[LETTERS];

        /*
         * Labels for each letter's position in the array. ("first", "second", etc)
         */
        String[] literalNth = {
            "First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth",
            "Ninth", "Tenth"
        };



        for (int counter = 1; counter <= LETTERS; counter++)
        {
            do //while character isn't valid
            {
                System.out.print("Please enter letter #" + counter + ": ");
                letter = user_input.nextLine();

                if (letter.length() != 1 || !Character.isLetter(letter.charAt(0)))
                {
                    System.out.print("That isn't a letter. ");
                } //end if isn't valid character
                else
                {
                    letterArray[counter - 1] = letter;
                } //end else is valid character
            } while (letter.length() != 1 || !Character.isLetter(letter.charAt(0)));
        } //end for each letter to be prompted

        System.out.println();

        for (int counter = 0; counter < LETTERS; counter++)
        {
            System.out.println(literalNth[counter] + " letter: " + letterArray[counter]);
        } //end for each letter prompted
    } //end method main
} //end class WeissLab8
