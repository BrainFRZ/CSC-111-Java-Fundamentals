/**************************************************************************************************
 *  Program Name:     Lab #7: Looping Lab with both types of loops
 *  Author:           Terry Weiss
 *  Date:             October 14, 2015
 *  Course/Section:   CSC 111-003W
 *  Program Description:
 *     This program prompts the User for a score between 0 and 100 (inclusive), until the User
 *  enters a valid number in the specified range using a while loop. It then prompts for a second
 *  score until the User enters a valid number in the specified range, but using a do-while loop.
 **************************************************************************************************/

import java.util.Scanner;

/*
 *  This class will prompt the User for a score between 0 and 100 (inclusive), until the User
 *  enters a valid number in the specified range using a while loop. It then prompts for a second
 *  score until the User enters a valid number in the specified range, but using a do-while loop.
 *
 *  Input data:
 *      (int) score1 - First score
 *      (int) score2 - Second score
 *  Output data:
 *      N/A
 *  Additional variables:
 *      (final int) MIN_SCORE – Minimum score allowed
 *      (final int) MAX_SCORE – Maximum score allowed
 *
 *  Formulas: None
 *
 *  Initial Algorithm:
 *  Prompt for a score between 0 and 100 until it’s within range
 *  Prompt for a second score between 0 and 100 until it’s within range
 */
public class WeissLab7
{
    /*
     *  This class will prompt the User for a score between 0 and 100 (inclusive), until the User
     *  enters a valid number in the specified range using a while loop. It then prompts for a
     *  second score until the User enters a valid number in the specified range, but using a
     *  do-while loop.
     *
     *  Refined Algorithm:
     *  DO
     *      Prompt for score1
     *      IF score1 < MIN_SCORE OR score1 > MAX_SCORE THEN
     *          Display error message
     *      END IF
     *  LOOP WHILE score1 < MIN_SCORE OR score1 > MAX_SCORE
     *
     *  Initialize score2 to MIN_SCORE – 1
     *  WHILE score2 < MIN_SCORE OR score2 > MAX_SCORE
     *      Prompt for score1
     *      IF score2 < MIN_SCORE OR score2 > MAX_SCORE THEN
     *          Display error message
     *      END IF
     *  END WHILE
     */
    public static void main( String args[] )
    {
        /*
         *  This is minimum score to be allowed
         */
        final int MIN_SCORE = 0;

        /*
         *  This is maximum score to be allowed
         */
        final int MAX_SCORE = 100;

        /*
         *  This is the first score to be prompted
         */
        int score1;

        /*
         *  This is the second score to be prompted
         */
        int score2;

        /*
         *  This object is used to capture the user's input.
         */
        Scanner user_input = new Scanner(System.in);


        // Prompting for the first score
        score1 = MIN_SCORE - 1;  // Not -1 in case MIN_SCORE is changed later
        while (score1 < MIN_SCORE || score1 > MAX_SCORE)
        {
            System.out.print("Please enter a score between 0 and 100: ");
            score1 = user_input.nextInt();

            if (score1 < MIN_SCORE || score1 > MAX_SCORE)
            {
                System.out.print("Invalid score. ");
            } //end if score1 is out of bounds
        } //end while score1 is out of bounds

        // Prompting for second score
        do //while score2 is out of bounds
        {
            System.out.print("Please enter a second score between 0 and 100: ");
            score2 = user_input.nextInt();

            if (score2 < MIN_SCORE || score2 > MAX_SCORE)
            {
                System.out.print("Invalid score. ");
            } //end if score2 is out of bounds
        } while (score2 < MIN_SCORE || score2 > MAX_SCORE);
    } //end method main
} //end class WeissLab7
