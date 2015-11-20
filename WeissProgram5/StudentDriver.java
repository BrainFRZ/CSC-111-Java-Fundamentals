/**************************************************************************************************
 *  Program Name:     Program #5
 *  Author:           Terry Weiss
 *  Date Due:         November 24, 2015
 *  Course/Section:   CSC 111-003W
 *  Program Description:
 *     This program simulates a student enrolled at a college. This class tests the Student class.
 **************************************************************************************************/

import java.util.Scanner;

public class StudentDriver {
    //Main method
    //-------------------------------------------------------
    // Handles main runtime used to test the Student class
    //-------------------------------------------------------
    // Initialize a hardcoded Student object to student1
    // Add course CSC111 with 4 credits
    // Display student1's details to test toString
    // Display student1's schedule
    //
    // DO
    //     Prompt User to enter course name
    //     Read course name
    //     Prompt User to enter course credits
    //     Add course name and course credits to student schedule
    //
    //     Prompt if user wants to enter another course
    // LOOP WHILE (prompt to continue is equal to a "y")
    // Display student1's schedule
    //
    // DO
    //     Prompt User to enter course name
    //     Read course name
    //     Drop course from student schedule
    //
    //     Prompt if user wants to drop another course
    // LOOP WHILE (prompt to continue is equal to a "y")
    // Display student1's schedule
    //-------------------------------------------------------
    public static void main(String[] args) {
        Student student1 = new Student("Fred Fergel",               // Name
                                       "0123",                      // Student ID
                                       "123 Main Street",           // Street Address
                                       "Smalltown", "NY", "12345",  // City, State, ZIP
                                       "Computer Science"           // Major
                                      );

        //Add a course
        student1.addCourse("CSC111", 4);  //NOTE:  DO NOT PUT A SPACE BETWEEN CSC AND 111

        //Test toString
        System.out.println("Student 1\n\n" + student1);

        //Print schedule
        System.out.println("Student 1's Schedule:\n\n");
        student1.displaySchedule();   //call method
        System.out.println();


        // Test adding new courses
        final Scanner scan = new Scanner(System.in);
        String prompt;
        String courseName;
        int courseCredits;
        
        do { //while user wants to add courses
            System.out.print("Please enter the name of the course: ");
            courseName = scan.next().substring(0, 6);
            System.out.print("How many credits is the course? ");
            courseCredits = scan.nextInt();

            student1.addCourse(courseName, courseCredits);

            System.out.print("Do you wish to add another course? [y/n] ");
            prompt = scan.next();
        } while (prompt.equals("y"));

        System.out.println("Student 1's New Schedule:\n\n");
        student1.displaySchedule();

        do { //while user wants to delete courses
            System.out.print("Please enter the name of the course to drop: ");
            courseName = scan.next().substring(0, 6);

            student1.dropCourse(courseName);

            System.out.print("Do you wish to drop another course? [y/n] ");
            prompt = scan.next();
        } while (prompt.equals("y"));

        System.out.println("Student 1's New Schedule:\n\n");
        student1.displaySchedule();
    } //end method main
} //end class StudentDriver
