/**************************************************************************************************
 *  Program Name:     Program #2: Conversion Chart
 *  Author:           Terry Weiss
 *  Date:             October 20, 2015
 *  Course/Section:   CSC 111-003W
 *  Program Description:
 *     This program displays an inches-to-centimeters conversion table. The input is the smallest
 *  number of inches and then the largest number of inches to be converted. The program then
 *  displays the conversion for each 6-inch increment between the start and end numbers. The end
 *  number must be between 6 and 36 inches larger than the start number. One inch is equivalent to
 *  2.54 centimeters. The program gives the option to run the program again.
 **************************************************************************************************/

import java.util.Scanner;


/*
 *  This class displays an inches-to-centimeters conversion table with 6-inch increments. One inch
 *  is equivalent to 2.54 centimeters.
 *
 *  Input data:
 *      (int) startRange – This is the first inch to be converted
 *      (int) endRange – This is the highest possible inch to be converted
 *      (String) userContinues – This is the user’s response to whether they want to continue
 *  Output data:
 *      (int) inch – This is the current inch being converted
 *      (double) centimeter – This is the number of centimeters equivalent to the current inch being
 *          converted, which will be formatted to two decimal points
 *  Additional data:
 *      (final double) CONVERSION_RATE – This is the conversion rate between inches and centimeters
 *      (final int) INTERVAL – This is interval between each conversion
 *      (final int) MAX_RANGE – This is maximum size of the range
 *
 *  Formulas:
 *      centimeter = inch * CONVERSION_RATE {centimeter = inch * 2.54}
 *
 *  Initial Algorithm:
 *  Prompt for the start number until a positive number is given
 *  Prompt for the end number until a number within range is given
 *  Display the table header
 *  Calculate and display the conversion from inches to centimeters for each 6-inch increment
 *      in the range, formatted into the table
 */
public class WeissProgram2
{

    /*
     *  This method displays an inches-to-centimeters conversion table. The input is the smallest
     *  number of inches and then the largest number of inches to be converted. The program then
     *  displays the conversion for each 6-inch increment between the start and end numbers. The end
     *  number must be between 6 and 36 inches larger than the start number. One inch is equivalent
     *  to 2.54 centimeters. The method gives the option to continue creating new tables.
     *
     *  Refined Algorithm:
     *  DO
     *      min = 1
     *      max = maximum Integer – MAX_RANGE
     *      DO
     *          Prompt startRange
     *          IF startRange < min THEN
     *              Display error message about negative number
     *          ELSE IF startRange > max THEN
     *              Display error message about being too big
     *          END IF
     *      LOOP WHILE startRange < min OR startRange > max
     *
     *      min = startRange + INTERVAL
     *      max = startRange + MAX_RANGE
     *      DO
     *          Prompt endRange
     *          IF endRange < min OR endRange > max THEN
     *              Display error message about being out of range
     *          END IF
     *      LOOP WHILE endRange < min OR max
     *
     *
     *      Display table header
     *      FOR inch = startRange TO endRange [STEP inch by INTERVAL]
     *          Calculate centimeter
     *          Display inch and centimeter, formatted to two decimals
     *      END FOR
     *
     *
     *      Prompt userContinues
     *  LOOP WHILE userContinues != "n" AND userContinues != "no"
     */
    public static void main( String[] args )
    {
        /*
         *  This is the conversion rate between inches and centimeters
         *  Currently 2.54cm per inch
         */
        final double CONVERSION_RATE = 2.54;

        /*
         *  This is interval between each conversion in inches
         */
        final int INTERVAL = 6;

        /*
         *  This is maximum size of the range
         */
        final int MAX_RANGE = 36;

        /*
         *  This is the first inch to be converted
         */
        int startRange;

        /*
         *  This is the highest possible inch to be converted
         */
        int endRange;

        /*
         *  This is the smallest number in bounds for the current prompt
         */
        int min;

        /*
         *  This is the highest number in bounds for the current prompt
         */
        int max;

        /*
         *  This is the current inch being converted
         */
        int inch;

        /*
         *  This is the number of centimeters equivalent to the current inch being converted, which
         *  will be formatted to two decimal points
         */
        double centimeter;

        /*
         *  This is the user's response to whether they want to continue
         */
        String userContinues;

        /*
         *  This object is used to capture the user's input
         */
        Scanner user_input = new Scanner(System.in);



        do //while User wants to continue
        {
            min = 1;
            max = Integer.MAX_VALUE - MAX_RANGE;
            do //while startRange is negative or too big
            {
                System.out.print("Please enter the first inch: ");
                startRange = user_input.nextInt();

                if (startRange < min)
                {
                    System.out.print("That's a negative number. ");
                } //end if startRange is negative
                else if (startRange > max)
                {
                    System.out.print("That's too big. ");
                } //end else if startRange is too big
            } while (startRange < min || startRange > max);

            min = startRange + INTERVAL;
            max = startRange + MAX_RANGE;
            do //while endRange is too close to startRange or too big
            {
                System.out.print("Please enter the highest inch (between "
                    + min + " and " + max + "): ");
                endRange = user_input.nextInt();

                if (endRange < min || endRange > max)
                {
                    System.out.print("That's not in range. ");
                } //end if endRange is out of bounds
            } while (endRange < min || endRange > max);


            // Display table
            System.out.println(""
                + "        Conversion Chart\n"
                + "    Inches       Centimeters\n"
                + "  **********    *************");

            for (inch = startRange; inch <= endRange; inch += INTERVAL)
            {
                centimeter = inch * CONVERSION_RATE;
                System.out.printf("  %10d    %13.2f\n", inch, centimeter);
            } //end for each interval in table


            System.out.print("Would you like to create another table? ");
            userContinues = user_input.next();
        } while (!userContinues.equalsIgnoreCase("n") && !userContinues.equalsIgnoreCase("no"));
    } //end method main
} //end class WeissProgram2
