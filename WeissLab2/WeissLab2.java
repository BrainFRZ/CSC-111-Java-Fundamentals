/**************************************************************************************************
* Program Name:     Computing the Area of a Circle
* Author:           Terry Weiss
* Date:             September 7, 2015
* Course/Section:   CSC 111-003W
* Program Description:
*    This program calculates and displays the area of a circle using a radius provided by the user.
***************************************************************************************************/

import java.util.Scanner;

/*
 *  This class will calculate and display the area of a circle.
 *
 *  Attributes:
 *      PI – This is the decimal value of pi.
 *      PI_SYMBOL – This is the Unicode character for pi (π).
 *      radius – This is the radius of the circle.
 *      circle – This is the instantiated WeissLab2 object.
 *  Behaviors:
 *      setRadius – This will allow the radius to be changed if necessary, and
 *                  will return the new radius.
 *      getRadius – This will allow the radius to be retrieved outside the object.
 *      getArea – This will calculate and return the area of the circle.
 *      factoredArea – This will generate the area as a factor of pi, so it can be seen in
 *                     a simplified and mathematically precise visual form.
 *
 *  Algorithm:
 *  Get the radius
 *  Calculate the area of the circle
 *  Display the area of the circle
 */
public class WeissLab2 {

    /*
     *  This is the decimal value of pi.
     */
    public final double PI = 3.14159265;

    /*
     *  This is the Unicode character for pi (π).
     */
    public final char PI_SYMBOL = '\u03C0';

    /*
     *  This is the radius of the circle. This is stored as a double since it will be working with
     *  PI, which is also a double.
     */
    private double radius;



    /*
     *  This is the constructor for the WeissLab2 object. It will set the radius of the circle
     *  based on the input provided.
     */
    public WeissLab2( double r )
    {
        radius = r;
    }

    /*
     *  This method allows the radius to be changed if necessary, and will return the new radius.
     */
    public double setRadius( double r )
    {
        return (radius = r);
    }

    /*
     *  This method allows the radius to be retrieved outside the object.
     */
    public double getRadius()
    {
        return radius;
    }

    /*
     *  This method calculates the area of the circle.
     *
     *  Area = pi * r^2
     */
    public double getArea()
    {
        return (PI * (radius * radius));
    }

    /*
     *  This method generates the area as a factor of pi, so it can be seem in a simplified
     *  and mathematically precise visual form.
     *
     *  Algorithm:
     *  Calculate the square of radius
     *  Convert to a String
     *  Append PI_SYMBOL
     */
    public String factoredArea()
    {
        return (Double.toString(radius * radius) + PI_SYMBOL);
    }




    /*
     *  This program will ask the user for a circle's radius and then calculate and
     *  print out the circle's area.
     *
     *  Algorithm:
     *  Get the radius (radius?)
     *  Make sure radius is valid, or ask again
     *  Create a WeissLab2 object using the radius to perform the calculations
     *  Define PI
     *  Calculate the area of the circle (getArea())
     *      getArea { PI * (radius * radius) }
     *  Generate the area as a factor of pi (factoredArea())
     *      factoredArea { radius * radius + PI_SYMBOL }
     *  Display area of circle as a decimal and as a factor of pi (area(), factoredArea())
     */
    public static void main( String[] args )
    {
        Scanner user_input = new Scanner(System.in);

        /*
         *  dimensions is used to capture the user's requested radius
         */
        String dimensions;

        /*
         *  r is used to see how big the radius is as a number
         */
        Double r = 0.0;


        // Continue to ask for the radius until it's within bounds
        while( r <= 0.0 )
        {
            System.out.print("What is the radius of the circle?  ");
            dimensions = user_input.next();

            try {
                r = Double.parseDouble(dimensions);
            } catch( NumberFormatException e ) {
                System.out.println("If only we could measure dimensions without numbers! "
                    + "Try a positive number.");
                continue;
            }

            if( r <= 0 )
            {
                // Leave my TARDIS alone!
                System.out.println("That's bigger on the inside than it is on the outside! "
                    + "Try a positive number.");
            }
        }


        /*
         *  circle is a WeissLab2 object instantiated using the user's radius
         */
        WeissLab2 circle = new WeissLab2(r);

        System.out.println("Your circle has an area of " + Double.toString(circle.getArea()) +
                " (" + circle.factoredArea() + ").");
    }

}
