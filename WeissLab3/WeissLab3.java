/**************************************************************************************************
*  Program Name:     Strings and Formatting
*  Author:           Terry Weiss
*  Date:             September 14, 2015
*  Course/Section:   CSC 111-003W
*  Program Description:
*     This program asks for various information about the user and then displays
*  a specific message based on the input.
***************************************************************************************************/

import java.util.Scanner;
import java.text.NumberFormat;


/*
 *  This class will ask for the user's name, hours slept in a day, and desired hourly income, then
 *  display a message based on the input.
 * 
 *  Algorithm:
 *  Get user’s first name
 *  Get user’s last name
 *  Get number of hours slept in a day
 *  Get desired hourly income
 *  Set the user’s first initial as the lower case first letter of their first name
 *  Set the user’s last initial as the lower case first letter of their last name
 *  Calculate the percentage of hours slept in a day, formatted as a percentage
 *  Calculate the salary based on a 40-hour week, formatted as a currency
 *  Display "<first initial> <last initial> sleeps <percentage> of each 24 hour period and \
 *          would like to earn <salary> per week."
 */
public class WeissLab3
{

    /*
     *  This method will ask for the user's name, hours slept in a day, and desired hourly income,
     *  then display a message based on the input.
     * 
     *  Algorithm:
     *  Get user’s first name (firstName)
     *  Set user’s last initial as the lower case first letter of their last name (lastInitial)
     *      Grab the first character of last name
     *      Convert the first character to lower case
     *  Get user’s last name (lastName)
     *  Set user’s first initial as the lower case first letter of their first name (firstInitial)
     *      Grab the first character of first name
     *      Convert the first character to lower case
     *  Get number of hours slept in a day (hoursSlept)
     *  Calculate percentage of hours slept in a day, formatted as a percentage (percentSlept)
     *      percentSlept = hoursSlept / HOURS_IN_DAY
     *  Get desired hourly income (desiredSalary)
     *  Calculate salary based on a 40-hour week, formatted as a currency (weeklySalary)
     *      weeklySalary = desiredSalary * HOURS_WORKED_IN_WEEK
     *  Display "<first initial> <last initial> sleeps <percentage> of each 24 hour period and \
     *          would like to earn <salary> per week."
     */
    public static void main( String[] args )
    {
        /*
         *  This is the total number of hours in a day.
         */
        final int HOURS_IN_DAY = 24;
        
        /*
         *  This is the total number of hours the user worked in a week.
         */
        final int HOURS_WORKED_IN_WEEK = 40;
        
        /*
         *  This is the user's first name.
         */
        String firstName;
        
        /*
         *  This is the user's first initial.
         */
        String firstInitial;

        /*
         *  This is the user's last name.
         */
        String lastName;
        
        /*
         *  This is the user's last intial.
         */
        String lastInitial;
        
        /*
         *  This is the number of hours the user sleeps in a day.
         */
        int hoursSlept;
        
        /*
         *  This is the percentage of hours the user sleeps out of a day, formatted as a percentage.
         */
        String percentSlept;
        
        /*
         *  This is to format the percentage of hours slept into a percentage
         */
        NumberFormat fmtPercent = NumberFormat.getPercentInstance();
        
        /*
         *  This is the amount of money the user would like to make in an hour.
         */
        double hourlySalary;
        
        /*
         *  This is the amount of money the user would like to make in a week,
         *  formatted as currency.
         */
        String weeklySalary;
        
        /*
         *  This is to format the weekly salary into currency.
         */
        NumberFormat fmtCurrency = NumberFormat.getCurrencyInstance();
        
        /*
         *  This is used to capture the user's input.
         */
        Scanner user_input = new Scanner(System.in);
        
        
        
        /*
         *  This block handles input/output while also generating the values for the final output.
         */
        System.out.print("What's your first name?  ");
        firstName = user_input.next();
        // Grab first name's first letter and convert to lower case as the first initial.
        firstInitial = firstName.substring(0, 1).toLowerCase();
        
        System.out.print("What's your last name?  ");
        lastName = user_input.next();
        lastInitial = lastName.substring(0, 1).toLowerCase();
        
        System.out.print("How many hours do you sleep in a day?  ");
        hoursSlept = Integer.parseInt(user_input.next());
        fmtPercent.setMaximumFractionDigits(2);
        percentSlept = fmtPercent.format((double)hoursSlept / HOURS_IN_DAY);
        
        System.out.print("What would you like to make in an hour?  ");
        hourlySalary = Double.parseDouble(user_input.next());
        weeklySalary = fmtCurrency.format(hourlySalary * HOURS_WORKED_IN_WEEK);
        
        
        System.out.println(firstInitial + " " + lastInitial + " sleeps " + percentSlept + 
                           " of each 24 hour period and would like to earn " + weeklySalary +
                           " per week.");
    }
}
