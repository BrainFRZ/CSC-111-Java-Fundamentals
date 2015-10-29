/**************************************************************************************************
 *  Program Name:     Lab #5: Call Price
 *  Author:           Terry Weiss
 *  Date:             September 29, 2015
 *  Course/Section:   CSC 111-003W
 *  Program Description:
 *     This program will calculate the cost of a phone call, where the cost is a flat rate of
 *  $0.99 for the first 10 minutes and then $0.10/minute after.
 **************************************************************************************************/

import java.util.Scanner;
import java.text.NumberFormat;


/*
 *  This class will calculate and display the cost of a phone call, where the cost is a flat rate of
 *  $0.99 for the first 10 minutes and then $0.10/minute after.
 *
 *  Algorithm:
 *  Get the length of the call in minutes
 *  Calculate cost of call
 *  Display length and cost of call
 */
public class WeissLab5
{

    /*
     *  This method will ask for the length of the call in minutes, then calculate and display the
     *  length of the call and cost as a currency. The cost is a flat rate of $0.99 for the first
     *  10 minutes and then $0.10/minute after.
     *
     *  Algorithm:
     *  Get the length of the call in minutes
     *  IF minutes == 0 THEN
     *      Display "No minutes were entered."
     *  ELSE
     *      Set the cost of the call to FLAT_RATE
     *      IF call is longer than INTRO_TIME THEN
     *          Add the MINUTE_RATE per number of minutes over to the current cost
     *      END IF
     *      Display the length of the call in minutes and the cost as a currency
     *  END IF
     */
    public static void main( String[] args )
    {
        /*
         *  This is the length of the call in minutes.
         */
        int minutes;
        
        /*
         *  This is the total cost of the call.
         */
        double cost;
        
        /*
         *  This is the number of minutes included in the original flat rate.
         *  Currently 10 minutes
         */
        final int INTRO_TIME = 10;
        
        /*
         *  This is the original flat rate price for the intro period.
         *  Currently $0.99
         */
        final double FLAT_RATE = 0.99;
        
        /*
         *  This is the cost per minute after the intro period.
         *  Currently $0.10/minute
         */
        final double MINUTE_RATE = 0.1;
        
        /*
         *  This object holds the currency format.
         */
        NumberFormat currency_format = NumberFormat.getCurrencyInstance();

        /*
         *  This object is used to capture the user's input.
         */
        Scanner user_input = new Scanner(System.in);

        
        System.out.print("How many minutes was your call?  ");
        minutes = user_input.nextInt();

        if (minutes == 0)
        {
            System.out.println("No minutes were entered.");
        } //end if minutes == 0

        else
        {
            cost = FLAT_RATE;
            if (minutes > INTRO_TIME)
            {
                cost += (minutes - INTRO_TIME) * MINUTE_RATE;
            } //end if minutes > INTRO_TIME
            
            System.out.println("Your " + minutes + "-minute call costs " +
                currency_format.format(cost) + ".");
        } //end else minutes != 0
    } //end main() method
} //end WeissLab5 class


/**************************************************************************************************
 *  Specified testing arguments:
 *
 *  9 minutes
 *  > Your 9-minute call costs $0.99.
 *  +PASSES
 *
 *  10 minutes
 *  > Your 10-minute call costs $0.99.
 *  +PASSES
 *
 *  11 minutes
 *  > Your 11-minute call costs $1.09.
 *  +PASSES
 *
 *  35 minutes
 *  > Your 35-minute call costs $3.49.
 *  +PASSES
 *
 *  0 minutes
 *  > No minutes were entered.
 *  +PASSES
 **************************************************************************************************/
