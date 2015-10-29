/**************************************************************************************************
 *  Program Name:     Lab #6: Grade Averages
 *  Author:           Terry Weiss
 *  Date:             October 6, 2015
 *  Course/Section:   CSC 111-003W
 *  Program Description:
 *     This program prompts the User to enter the number of grades they wish to enter. It will then
 *  use a counter-controlled `while` loop to get that many grades. In the loop, it will compute a
 *  running total of the grades and keep track of the number of grades counted. After the `while`
 *  loop is finished, the program will compute the average of all the grades entered and display
 *  the average.
 **************************************************************************************************/

import java.util.Scanner;
import java.text.NumberFormat;


/*
 *  This class will keep a running total of the grades entered and calculate and display the
 *  average of all the grades.
 *
 *  Initial Algorithm:
 *  Get the total number of grades to be counted
 *  WHILE counter <= total number of grades
 *      Prompt for a grade
 *      Add grade to total sum of grades
 *      Increment counter
 *  END WHILE
 *  Display average of grades entered
*/
public class WeissLab6
{

    /*
     *  This function prompts the User to enter the number of grades they wish to enter. It will
     *  then use a counter-controlled `while` loop to get that many grades. In the loop, it will
     *  compute a running total of the grades and keep track of the number of grades counted. After
     *  the `while` loop is finished, the program will compute the average of all the grades
     *  entered and display the average.
     *
     *  Data Requirements:
     *  Input
     *      (int) totalGrades – This is the total number of grades that will be entered
     *      (int) grade – This is the value of the current entered grade
     *  Output
     *      (double) gradeAvg – This is the final average of all the grades
     *  Additional Variables
     *      (int) counter – This is the number of the current iteration
     *      (int) gradeSum – This is the running total of all the grades entered so far
     *
     *  Refined Algorithm:
     *  Prompt totalGrades
     *
     *  Initialize counter to 0
     *  Initialize gradeSum to 0
     *  WHILE counter < totalGrades
     *      Get grade
     *      Add grade to gradeSum
     *      Increment counter by 1
     *  END WHILE
     *
     *  IF totalGrades <= 0 THEN
     *      Display error message that no grades were entered
     *  ELSE
     *      gradeAvg = gradeSum / totalGrades
     *      Display gradeAvg
     *  END IF
     */
    public static void main( String[] args )
    {

        /*
         *  This is the total number of grades that will be entered
         */
        int totalGrades;

        /*
         *  This is the running total of all the grades entered so far
         */
        int gradeSum;

        /*
         *  This is the final average of all the grades
         */
        double gradeAvg;

        /*
         *  This is the value of the current entered grade
         */
        int grade;

        /*
         *  This is the number of the current iteration
         */
        int counter;

        /*
         *  This object holds the number format, rounded to hundredths.
         */
        NumberFormat number_format = NumberFormat.getNumberInstance();
        number_format.setMaximumFractionDigits(2);

        /*
         *  This object is used to capture the user's input.
         */
        Scanner user_input = new Scanner(System.in);


        System.out.print("How many grades would you like to enter? ");
        totalGrades = user_input.nextInt();

        gradeSum = 0;
        counter = 0;
        while (counter < totalGrades)
        {
            System.out.print("Please enter a grade: ");
            grade = user_input.nextInt();
            gradeSum += grade;
            counter++;
        } //end while counter < totalGrades

        if (totalGrades <= 0)
        {
            System.out.println("No grades were entered.");
        }
        else // else totalGrades > 0
        {
            gradeAvg = gradeSum / (double)totalGrades;
            System.out.println("The average grade was " + number_format.format(gradeAvg) + "%.");
        } //end if totalGrades <= 0
    } //end function main

} //end class WeissLab6
