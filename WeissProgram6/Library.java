/**************************************************************************************************
 *  Program Name:     Program #6
 *  Class Name:       Library
 *  Author:           Terry Weiss
 *  Date Written:     November 24, 2015
 *  Program Description:
 *     This class handles everything with the `Bookshelf`. It allows the User to store a book,
 *  browse the list of books by various categories, view the details of a particular book and
 *  take a book off the shelf.
 **************************************************************************************************/

//import Book;
//import Bookshelf;
import java.util.Scanner;

/*
 *  This class is the driver behind {@link Bookshelf}. It uses menus to allow the User to store a
 *  Book, browse the list of Books by various categories, view the details of a particular Book and
 *  take a book off the shelf.
 */
public class Library {
    //Definitions of all menu options
    private static final int OPTION_ADD_BOOK       = 1;
    private static final int OPTION_BROWSE         = 2;
    private static final int OPTION_BROWSE_DETAILS = 3;
    private static final int OPTION_QUIT           = 4;

    //Bookshelf instance that holds each Book
    private static final Bookshelf shelf = new Bookshelf();;

    //User input reader
    private static final Scanner input = new Scanner(System.in);



    //Method initializes bookshelf with starter books
    //---------------------------------------------------------------------------------------------
    //  Preloads the list of top 5 best-selling single-volume novels of all time as per Wikipedia.
    //---------------------------------------------------------------------------------------------
    //  Algorithm:
    //  Initialize new bookshelf
    //  Add 1st book
    //  Add 2nd book
    //  Add 3rd book
    //  Add 4th book
    //  Add 5th book
    //---------------------------------------------------------------------------------------------
    private static void initializeShelf() {
        shelf.addBook("A Tale of Two Cities", "Charles Dickens", 1859, "Historical Novel");
        shelf.addBook("The Lord of the Rings", "J. R. R. Tolkien", 1954, "High Fantasy");
        shelf.addBook("The Hobbit", "J. R. R. Tolkien", 1937, "High Fantasy");
        shelf.addBook("The Little Prince", "Antoine de Saint-Exupéry", 1943, "Fable");
        shelf.addBook("Harry Potter", "J. K. Rowling", 1997, "Fantasy");
    } //end method initializeShelf



    //Method handles main menu
    //---------------------------------------------------------------------------------------------
    //  Creates the main menu prompt message and prompts the user for which option to proceed.
    //---------------------------------------------------------------------------------------------
    //  Output: Menu option selected : Int
    //
    //  Algorithm:
    //  Initialize option to 0
    //  DO
    //      Display menu options
    //      Get option from user
    //
    //      IF (option is out of bounds THEN
    //          Display error message
    //      END IF
    //  LOOP WHILE (option is in bounds)
    //---------------------------------------------------------------------------------------------
    private static int mainMenu() {
        int option = 0;

        do { //while option is out of bounds
            System.out.print("\n"
                    + "\t1. Add a book\n"
                    + "\t2. Browse\n"
                    + "\t3. Browse Details\n"
                    + "\t4. Quit\n"
                    + "Please select an option: ");

            //must use nextLint and parseInt since nextInt doesn't capture new-line and would skip
            //next prompt
            option = Integer.parseInt(input.nextLine());

            if (option < OPTION_ADD_BOOK || option > OPTION_QUIT) {
                System.out.print("Not a valid option.");
            } //end if option is out of bounds
        } while (option < OPTION_ADD_BOOK || option > OPTION_QUIT);

        return option;
    } //end method mainMenu


    //Method adds a Book
    //---------------------------------------------------------------------------------------------
    //  Prompts the user for a Book's details, creates the new Book and adds it to the Bookshelf
    //---------------------------------------------------------------------------------------------
    //  Output: Book object that was added
    //
    //  Algorithm:
    //  Get title
    //  Get author
    //  Get year it was written
    //  Get genre
    //  Create book with given info
    //  Add created book to bookshelf and display success message
    //  IF (shelf was resized) THEN
    //      Alert about resize
    //  END IF
    //---------------------------------------------------------------------------------------------
    private static Book addBook() {
        System.out.print("Enter title: ");
        String title = input.nextLine();

        System.out.print("Enter author: ");
        String author = input.nextLine();

        System.out.print("Enter year book was written: ");
        int year = Integer.parseInt(input.nextLine());

        System.out.print("Enter genre: ");
        String genre = input.nextLine();

        Book book = new Book(title, author, year, genre);
        if (shelf.addBook(title, author, year, genre)) {
            System.out.println("Shelf is full. Resizing to " + shelf.getSize() + " slots. . .");
        } //end if shelf was resized
        System.out.println("Added " + book + " to the shelf.");

        return book;
    } //end method addBook

    //Method displays brief display of each book
    //---------------------------------------------------------------------------------------------
    // Displays all Books on the Bookshelf based on their String representation. Currently each
    // Book is displayed by its title
    //---------------------------------------------------------------------------------------------
    private static void browse() {
        System.out.println("\nAll books in " + shelf + ":");
        System.out.print(shelf.browse());
    } //end method browse

    //Method displays details of each book
    //---------------------------------------------------------------------------------------------
    //  Displays details of each Book on the Bookshelf
    //---------------------------------------------------------------------------------------------
    private static void browseDetails() {
        System.out.println("\nDetails of books in " + shelf + ":");
        System.out.print(shelf.browseDetails());
    } //end method browseDetails




    //Main method
    //---------------------------------------------------------------------------------------------
    //  Initializes the Bookshelf with 5 preloaded books, and runs the main menu to allow the User
    //  to store a Book and browse the list of Books briefly or in detail.
    //---------------------------------------------------------------------------------------------
    //  Algorithm:
    //  Initialize Bookshelf with preloaded books
    //
    //  DO
    //      Prompt for menu option
    //
    //      IF (option == add book) THEN
    //          Add a book
    //      ELSE IF (option == browse) THEN
    //          Browse shelf
    //      ELSE IF (option == browse details) THEN
    //          Display details of each book
    //      ELSE IF (option == quit) THEN
    //          Quit
    //      ELSE
    //          Display error message
    //      END IF
    //  LOOP WHILE (menu option isn't valid)
    //---------------------------------------------------------------------------------------------
    public static void main( String args[] ) {
        int choice;

        initializeShelf();

        do { //until User chooses to quit
            choice = mainMenu();

            switch (choice) {
                case OPTION_ADD_BOOK:
                    addBook();
                    break;
                case OPTION_BROWSE:
                    browse();
                    break;
                case OPTION_BROWSE_DETAILS:
                    browseDetails();
                    break;
                case OPTION_QUIT:
                    System.out.println("Please come again!");
                    break;
                default:
                    System.out.println("**ERROR**: Main menu option doesn't exist");
            } //end switch of selected menu option
        } while (choice != OPTION_QUIT);
    } //end method main
} //end class Library
