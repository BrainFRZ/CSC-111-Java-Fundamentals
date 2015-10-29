/**************************************************************************************************
 *  Program Name:     Program #1: 3 Number Sort
 *  Author:           Terry Weiss
 *  Date:             September 29, 2015
 *  Course/Section:   CSC 111-003W
 *  Program Description:
 *     This program will prompt the user for three numbers and display them in ascending order.
 **************************************************************************************************/

import java.util.Scanner;

/*
 *  This class will prompt the user for three numbers and display them in ascending order.
 *
 *  Input data:
 *      (int) number1 - First number
 *      (int) number2 - Second number
 *      (int) number3 - Third number
 *  Output data:
 *      (int) number1 - First number
 *      (int) number2 - Second number
 *      (int) number3 - Third number
 *      (int[]) list - List of numbers in ascending order
 *
 *  Formulas: None
 *
 *  Initial Algorithm:
 *  Get 3 numbers
 *  Add the smallest number to a list
 *  Add the second smallest number to a list
 *  Add the remaining number to a list
 *  Display the list in ascending order
 */
public class WeissProgram1
{

    /*
     *  This method will prompt the user for three numbers and display them in ascending order.
     *
     *  Refined Algorithm:
     *  Get 3 numbers
     *  IF number1 < number2 AND number1 < number3 THEN
     *      Put number1 first in list
     *      IF number2 < number3 THEN
     *          Put number2 second in list
     *          Put number3 third in list
     *      ELSE
     *          Put number3 second in list
     *          Put number2 third in list
     *      END IF
     *  ELSE IF number2 < number1 AND number2 < number3 THEN
     *      Put number2 first in list
     *      IF number1 < number3 THEN
     *          Put number1 second in list
     *          Put number3 third in list
     *      ELSE
     *          Put number3 second in list
     *          Put number1 third in list
     *      END IF
     *  ELSE
     *      Put number3 first in list
     *      IF number1 < number2 THEN
     *          Put number1 second in list
     *          Put number2 third in list
     *      ELSE
     *          Put number2 second in list
     *          Put number1 third in list
     *      END IF
     *  END IF
     *  Display numbers from list in ascending order
     */
    public static void main( String[] args )
    {
        /*
         *  This is the first number given by the user.
         */
        int number1;

        /*
         *  This is the second number given by the user.
         */
        int number2;

        /*
         *  This is the third number given by the user.
         */
        int number3;

        /*
         *  This is the list of numbers in ascending order.
         */
        int[] list = { 0, 0, 0 };

        /*
         *  This object captures the user’s input.
         */
        Scanner user_input = new Scanner(System.in);


        System.out.print("First number: ");
        number1 = user_input.nextInt();
        System.out.print("Second number: ");
        number2 = user_input.nextInt();
        System.out.print("Third number: ");
        number3 = user_input.nextInt();

        // if number1 is smallest
        if (number1 < number2 && number1 < number3)
        {
            list[0] = number1;
            if (number2 < number3)
            {
                list[1] = number2;
                list[2] = number3;
            } //end if number2 < number3
            else
            {
                list[1] = number3;
                list[2] = number2;
            } //end else number3 >= number2
        } //end if number1 is smallest

        // if number2 is smallest
        else if (number2 < number1 && number2 < number3)
        {
            list[0] = number2;
            if (number1 < number3)
            {
                list[1] = number1;
                list[2] = number3;
            } //end if number1 < number3
            else
            {
                list[1] = number3;
                list[2] = number1;
            } //end else number1 >= number3
        } //end else if number2 is smallest

        // if number3 is smallest
        else
        {
            list[0] = number3;
            if (number1 < number2)
            {
                list[1] = number1;
                list[2] = number2;
            } //end if number1 < number2
            else
            {
                list[1] = number2;
                list[2] = number1;
            } //end else number1 >= number2
        } //end else number3 is smallest


        System.out.println(number1 + ", " + number2 + ", and " + number3 + " in ascending "
                + "order is: {" + list[0] + ", " + list[1] + ", " + list[2] + "}");
    } //end main method

} //end class WeissProgram1


/**************************************************************************************************
 *  Specified testing arguments:
 *
 *  3, 2, 1
 *  > 3, 2, and 1 in ascending order is: {1, 2, 3}
 *  +PASSES
 *
 *  3, 1, 2
 *  > 3, 1, and 2 in ascending order is: {1, 2, 3}
 *  +PASSES
 *
 *  1, 2, 3
 *  > 1, 2, and 3 in ascending order is: {1, 2, 3}
 *  +PASSES
 *
 *  1, 3, 2
 *  > 1, 3, and 2 in ascending order is: {1, 2, 3}
 *  +PASSES
 *
 *  2, 1, 3
 *  > 2, 1, and 3 in ascending order is: {1, 2, 3}
 *  +PASSES
 *
 *  2, 3, 1
 *  > 2, 3, and 1 in ascending order is: {1, 2, 3}
 *  +PASSES
 **************************************************************************************************/
