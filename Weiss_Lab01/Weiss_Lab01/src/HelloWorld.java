/**********************************************************************
* Program Name:     Hello World
* Author:           Terry Weiss
* Date:             August 31, 2015
* Course/Section:   CSC 111-003W
* Program Description:
*    This program will display the message "Hello World!"
**********************************************************************/

/************************** Compiler Directives **********************/

//Pre-Processor Declaration Section

//imports
import java.util.Scanner;

public class HelloWorld   //BEGIN Class Definition
{
    public static void main (String[] args)  //BEGIN Main Method
    {
        //Data Declaration Section
        Scanner scan = new Scanner(System.in);

        //Display message
        System.out.print ("Hello World!");
        System.out.print ("\n\n");

    }   //END main
}//END class
