/**************************************************************************************************
 *  Program Name:     Parking Fees
 *  Author:           Terry Weiss
 *  Date:             September 21, 2015
 *  Course/Section:   CSC 111-003W
 *  Program Description:
 *     This program will calculate and display how long a car has been parked in minutes and hours,
 *  including the parking fees where the charges are $1.00 per hour and $1.00 for a partial hour.
 **************************************************************************************************/

import java.util.Scanner;
import java.text.NumberFormat;


/*
 *  This class will calculate and display how long a car has been parked in minutes and hours,
 *  including the parking fees where the charges are $1.00 per hour and $1.00 for a partial hour.
 *
 *  Algorithm:
 *  Get number of minutes parked
 *  Calculate number of hours and minutes
 *  Calculate the parking fee
 *  Display the parking fee, formatted as a currency
 */
public class WeissLab4
{

    /*
     *  This method will ask for the total number of minutes parked, then calculate and display a
     *  the hours and minutes parked as well as the parking fee, where the charges are $1.00 per
     *  hour and $1.00 for a partial hour.
     *
     *  Algorithm:
     *  Get the total number of minutes parked (totalMinutes?)
     *  IF total minutes parked is 0 THEN
     *      Display error message regarding invalid parking time
     *  ELSE
     *      Calculate number of hours parked (hoursParked)
     *          hoursParked = totalMinutes / 60
     *      Calculate remaining number of minutes parked (minutesParked)
     *          minutesParked = totalMinutes % 60
     *      Display number of hours and minutes parked
     *          "Your car has been parked for x hours and x minutes."
     *      Calculate the parking fee (parkingFee)
     *          parkingFee = hoursParked * PARKING_RATE
     *      IF there are minutes remaining THEN
     *          Add another hour’s fee, rounding up from partial hour
     *              parkingFee += PARKING_RATE
     *      END IF
     *      Display parking fee, formatted as a currency
     *          "You owe $xx.xx in parking fees."
     *  END IF
     */
    public static void main( String[] args )
    {
        /*
         *  This is the regular hourly cost to park.
         */
        final double PARKING_RATE = 1.0d;

        /*
         *  This is the total number of minutes parked.
         */
        int totalMinutes;

        /*
         *  This is the number of hours parked.
         */
        int hoursParked;

        /*
         *  This is the number of minutes parked left over.
         */
        int minutesParked;

        /*
         *  This is the total cost of the parking fee.
         */
        double parkingFee;

        /*
         *  This object holds the currency format.
         */
        NumberFormat currency_format = NumberFormat.getCurrencyInstance();

        /*
         *  This object is used to capture the user's input.
         */
        Scanner user_input = new Scanner(System.in);


        System.out.print("How many minutes were you parked?  ");
        totalMinutes = user_input.nextInt();

        if (totalMinutes == 0)
        {
            System.out.println("This was not a valid parking time.");
        }
        else
        {
            hoursParked = totalMinutes / 60;
            minutesParked = totalMinutes % 60;

            System.out.println("Your car has been parked for " + hoursParked + " hours and "
                    + minutesParked + " minutes.");

            parkingFee = hoursParked * PARKING_RATE;

            // If there are any extra minutes, round up from the partial hour by adding another
            // hour's fee.
            if (minutesParked > 0)
            {
                parkingFee += PARKING_RATE;
            }

            System.out.println("You owe " + currency_format.format(parkingFee) +
                    " in parking fees.");
        }
    }
}


/**************************************************************************************************
 *  Specified testing arguments:
 *
 *  65 minutes
 *  > Your car has been parked for 1 hours and 5 minutes.
 *  > You owe $2.00 in parking fees.
 *  +PASSES
 *
 *  345 minutes
 *  > Your car has been parked for 5 hours and 45 minutes.
 *  > You owe $6.00 in parking fees.
 *  +PASSES
 *
 *  120 minutes
 *  > Your car has been parked for 2 hours and 0 minutes.
 *  > You owe $2.00 in parking fees.
 *  +PASSES
 *
 *  35 minutes
 *  > Your car has been parked for 0 hours and 35 minutes.
 *  > You owe $1.00 in parking fees.
 *  +PASSES
 *
 *  0 minutes
 *  > This was not a valid parking time.
 *  +PASSES
 **************************************************************************************************/
