/**************************************************************************************************
 *  Program Name:     Program #5
 *  Author:           Terry Weiss
 *  Date Due:         November 24, 2015
 *  Course/Section:   CSC 111-003W
 *  Program Description:
 *     This program simulates a student enrolled at a college. The student may add or drop courses,
 *  and can have up to 6 courses or 18 credits. The Student's name, ID, address and major are all
 *  stored. The student's schedule may also be displayed.
 **************************************************************************************************/

public class Student {
    //Instance Data
    private final String studentName;
    private final String studentID;
    private final String streetAddress;
    private final String city;
    private final String state;
    private final String zipCode;
    private String major;

    private static final int MAX_CREDITS = 18;
    private int totalCredits = 0; // start out enrolled with no credits

    private static final int SIZE = 6;
    private String[] schedule = new String[SIZE];
    private int courseNumber = 0; // start out enrolled with no courses




    //Create Constructor:
    //Initializes the student data at instantiation time.
    //-------------------------------------------------------
    //  Sets up the student's information.
    //-------------------------------------------------------
    public Student(String name, String id, String address, String cityName, String stateName,
                   String zip, String area)
    {
        studentName   = name;
        studentID     = id;
        streetAddress = address;
        city          = cityName;
        state         = stateName;
        zipCode       = zip;
        major         = area;
    }//end Student Constructor



    //Method to determine if maximum allowed credits have been exceeded
    //-------------------------------------------------------
    //  Returns true if total credits does not exceed maximum allowable credits (currently 18).
    //-------------------------------------------------------
    // Input:   Number of credits of new course:  By-Value Integer
    // Output:  True or False:  Boolean through method name.
    //
    // IF (the number of credits of the new course + current credits <= maximum credits allowed) THEN
    //     Return true
    // ELSE
    //     Return false
    // END IF
    //-------------------------------------------------------
    private boolean checkCredits(int numCredits) {
        if (numCredits + totalCredits <= MAX_CREDITS) {
            return true;  //return a true if still less than credit limit
        } //end if max credits are exceeded
        else {
            return false;  //return a false if credit limit is exceeded
        } //end else max credits aren't exceeded
    }//end method checkCredits

    //Method to determine if course's location in the schedule
    //-------------------------------------------------------
    //  Returns the location of given course exists in the student's schedule, or -1 if it
    //  doesn't exist
    //-------------------------------------------------------
    // Input:   Name of course: String
    // Output:  Index of course: Int
    //
    // Initialize flag to false
    // Initialize index to number of courses - 1
    //
    // IF course number > 0 THEN
    //     WHILE index >= 0 AND flag is false
    //         IF current course name == name of course we're looking for THEN
    //             Set flag to true
    //         ELSE
    //             Decrement index
    //         END IF
    //     END WHILE
    // ELSE
    //     Set course number to -1
    // END IF
    //
    // Output index
    //-------------------------------------------------------
    public int courseIndex(String course) {
        boolean flag = false;
        int index = courseNumber - 1; // Start at the current number of courses

        while (index >= 0 && !flag) {
            if (schedule[index].substring(0, 6).equalsIgnoreCase(course)) {
                flag = true;
            } //end if the current course in the list is the course we're looking for
            else {
                index--;
            } //end else course isn't what we're looking for
        } //end while the list isn't over and we haven't found the course

        return index;
    } //end method courseExists


    //Method to add a course to the student’s schedule
    //-------------------------------------------------------
    // Adds a course to the array if total credits does not exceed 18.
    //-------------------------------------------------------
    // Input:  Course Name:  String
    //         Number of credits:  Integer
    //
    // Output:  Message if the student can't register.
    //
    // IF (the course number is less than the number of positions in the array) THEN
    //     IF (credit check returns true) THEN
    //         add course to schedule array at position indicated by course number
    //         add the course credits to the total credits
    //         increment the number of courses
    //     ELSE
    //         Display maximum credits exceeded message
    //     END IF //credit check
    // ELSE
    //     Display maximum courses exceeded
    // END IF //course number less than courses allowed
    //-------------------------------------------------------
    public void addCourse(String course, int numCredits) {
        if (courseNumber < SIZE) {
            if (checkCredits(numCredits)) {
                //add course
                schedule[courseNumber] = course.toUpperCase() + ":\t\t" + numCredits + "\tCredits\n";

                //increment number of credits
                totalCredits = totalCredits + numCredits;

                //increment number of courses
                courseNumber = courseNumber + 1;
            } //end if we're under maximum credits
            else {
                System.out.println("You have exceeded the maximum allowed credits.");
            }//end else we can't add more when over max
        } //end if we're under the maximum number of classes
        else {
            System.out.println("You have exceeded " + SIZE + " courses.");
        }//end else we're past the maximum number of classes
    }//end method addCourse


    //Method to display the schedule
    //-------------------------------------------------------
    //  Will only print out the courses added to the array.
    //-------------------------------------------------------
    // Output:  Student's schedule
    //
    // FOR index = 0 TO courseNumber
    //     Print course number and name
    // NEXT index
    //-------------------------------------------------------
    public void displaySchedule() {
        for (int index = 0; index < courseNumber; index++) {
            System.out.println("Course #" + (index + 1) + " " + schedule[index] + "\n");
        }//end for each course on the schedule
    }//end method displaySchedule


    //Method to display the location of the given course on the schedule
    //-------------------------------------------------------
    //  Will display the course's location on the schedule, or if it doesn't exist
    //-------------------------------------------------------
    // Input:  Course Name:  String
    //
    // Output:  Message if the course isn't on the schedule.
    //
    // Algorithm:
    // Initialize index to course's location
    //
    // IF index == -1 THEN
    //     Display message the course name wasn't found
    // ELSE
    //     Display course name found at index
    // END IF
    //-------------------------------------------------------
    public void searchCourse(String course) {
        int index = courseIndex(course);

        if (index == -1) {
            System.out.println(course + " isn't on the schedule.");
        } //end if index isn't in the array
        else {
            System.out.println(course + " is " + (index + 1) + " on the schedule.");
        } //end else course is on the schedule
    } //end method searchCourse


    //Method to drop a course from the student’s schedule
    //-------------------------------------------------------
    // Removes a course from the array and shifts remaining courses forward
    //-------------------------------------------------------
    // Input:  Course Name:  String
    //
    // Output:  Message if the course isn't on the schedule.
    //
    // IF (the course number is less than the number of positions in the array) THEN
    //     IF (credit check returns true) THEN
    //         add course to schedule array at position indicated by course number
    //         add the course credits to the total credits
    //         increment the number of courses
    //     ELSE
    //         Display maximum credits exceeded message
    //     END IF //credit check
    // ELSE
    //     Display maximum courses exceeded
    // END IF //course number less than courses allowed
    //-------------------------------------------------------
    public void dropCourse(String course) {
        int index = courseIndex(course);

        if (index == -1) {
            System.out.println(course + " isn't on the schedule.");
        } //end if course isn't on schedule
        else {
            if (index != courseNumber - 1) {
                for (int i = index; i < courseNumber; i++) {
                    schedule[i] = schedule[i + 1];
                } //end for each course left
            } //end if course isn't the last one

            courseNumber--;
        } //end else course is on schedule
    } //end method dropCourse



    //Method to Return student information as string:
    //-------------------------------------------------------
    //  Returns the student information as a formatted string.
    //-------------------------------------------------------
    @Override
    public String toString() {
        return "Name:\t\t\t"      + studentName + "\n"
                + "ID:\t\t\t"     + studentID + "\n"
                + "Address:\t\t"  + streetAddress + "\n"
                + "City:\t\t\t"   + city + "\n"
                + "State:\t\t\t"  + state + "\n"
                + "Zip Code:\t\t" + zipCode + "\n"
                + "Major:\t\t\t"  + major + "\n";
    }//end method toString
} //end class Student
