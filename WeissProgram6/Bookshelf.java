/**************************************************************************************************
 *  Program Name:     Program #6
 *  Class Name:       Book
 *  Author:           Terry Weiss
 *  Date Written:     November 24, 2015
 *  Program Description:
 *     This class contains instance data for a bookshelf that is full of `Book`s. It allows the
 *  User to store a book, browse the list of books, view the details of a particular book and
 *  take a book off the shelf.
 **************************************************************************************************/

//import Book;


/*
 * Contains instance data for a bookshelf that holds {@link Book}s. It allows the User to store a
 * Book, browse the list of Books, view the details of a particular Book and take a Book off
 * the Bookshelf.
*/
public class Bookshelf {
    private static final int DEFAULT_SHELF_SIZE = 5; // Default number of books and size to start with
    private static final int RESIZE_MULTIPLIER = 2;  // Multiplier for new size of shelf if flooded

    private int size;           // Current size the shelf
    private int books;          // Current number of books on the shelf
    private Book[] bookList;    // list of Book objects


    //Bookshelf constructor
    //---------------------------------------------------------------------------------------------
    // Constructs a new Bookshelf instance using the default size
    //---------------------------------------------------------------------------------------------
    public Bookshelf() {
        bookList = new Book[DEFAULT_SHELF_SIZE];
        size = DEFAULT_SHELF_SIZE;
        books = 0;
    } //end constructor Bookshelf

    //Method gets number of books on shelf
    //---------------------------------------------------------------------------------------------
    // Provides current number of Books on the shelf
    //---------------------------------------------------------------------------------------------
    public int getNumberOfBooks() {
        return books;
    }

    //Method gets size of bookshelf
    //---------------------------------------------------------------------------------------------
    // Provides current size of the Bookshelf
    //---------------------------------------------------------------------------------------------
    public int getSize() {
        return size;
    }


    //Method adds a book
    //---------------------------------------------------------------------------------------------
    // Adds a Book to the Bookshelf based on given title, year written, author and genre.
    //---------------------------------------------------------------------------------------------
    //  Input: title  : String, book's title
    //         author : String, book's author
    //         year   : int,    year the book was published
    //         genre  : String, book's genre
    //
    //  Output: resized : Boolean, if shelf was resized
    //
    //  Algorithm:
    //  Initialize resized to false
    //
    //  IF (books == size) THEN
    //      Multiply size by 2
    //      Resize bookshelf to new size
    //      Change resized to true
    //  END IF
    //
    //  Create new book based on given title, author, year and genre
    //  Add book to next open cell
    //  Increment current number of books
    //---------------------------------------------------------------------------------------------
    public boolean addBook(String title, String author, int year, String genre) {
        boolean resized = false;

        if (books == size) {
            size *= RESIZE_MULTIPLIER;
            resizeShelf(size);
            resized = true;
        } //end if bookshelf needs to be resized

        Book book = new Book(title, author, year, genre);
        bookList[books] = book;
        books++;

        return resized;
    } //end method addBook

    //Method resizes bookshelf
    //---------------------------------------------------------------------------------------------
    //  Resizes the bookshelf to the new specified size
    //---------------------------------------------------------------------------------------------
    //  Input: newSize : Integer, new size of bookshelf
    //
    //  Algorithm:
    //  Initialize new bookshelf of the new size
    //  Set current shelf's size to the given new size
    //
    //  FOR i = 0 TO current shelf's size
    //      Assign current book to corresponding cell in new shelf
    //  NEXT i
    //
    //  Replace current shelf with new shelf
    //---------------------------------------------------------------------------------------------
    private void resizeShelf(int newSize) {
        Book[] newShelf = new Book[newSize];
        size = newSize;

        for (int i = 0; i < bookList.length; i++) {
            newShelf[i] = bookList[i];
        } //end for each book on the shelf

        bookList = newShelf;
    } //end method resizeShelf


    //Method gives list of books
    //---------------------------------------------------------------------------------------------
    //  Provides a String of all Books on the Bookshelf using their String representation.
    //---------------------------------------------------------------------------------------------
    //  Output: list : String, list of Books
    //
    //  Algorithm:
    //  Initialize list to empty String
    //  FOR i = 0 TO current number of books
    //      Add current Book's string representation to list and a new-line
    //  NEXT i
    //---------------------------------------------------------------------------------------------
    public String browse() {
        String list = "";

        for (int i = 0; i < books; i++) {
            list += bookList[i] + "\n";
        } //end for each book on the shelf

        return list;
    } //end method browse

    //Method gives detailed list of books
    //---------------------------------------------------------------------------------------------
    //  Provides a String of all Books on the Bookshelf using their details.
    //---------------------------------------------------------------------------------------------
    //  Output: list : String, list of Books
    //
    //  Algorithm:
    //  Initialize list to empty String
    //  FOR i = 0 TO current number of books
    //      Add current Book's details to list and a new-line
    //  NEXT i
    //---------------------------------------------------------------------------------------------
    public String browseDetails() {
        String list = "";

        for (int i = 0; i < books; i++) {
            list += bookList[i].displayDetails() + "\n\n";
        } //end for each book on the shelf

        return list;
    } //end method browse

    //Method Converts object to String
    //---------------------------------------------------------------------------------------------
    //  String representation of the Bookshelf
    //---------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Bookshelf holding " + books + " out of " + size + " books.";
    } //end method toString
} //end class Bookshelf
