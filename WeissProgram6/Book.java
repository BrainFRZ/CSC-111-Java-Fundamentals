/**************************************************************************************************
 *  Program Name:     Program #6
 *  Class Name:       Book
 *  Author:           Terry Weiss
 *  Date Written:     November 24, 2015
 *  Program Description:
 *     This class contains instance data for a book that will be used in `Bookshelf`. It contains
 *  instance data for the title, author, genre, and number of pages.
 **************************************************************************************************/

/*
 * This class contains instance data for a book that will be used in {@link Bookshelf}, including
 * the title, author, genre, and number of year.
 */
public class Book {
    private static final String DEFAULT_AUTHOR = "Unknown"; //Default author name
    private static final String DEFAULT_GENRE  = "General"; //Default genre name

    private static int untitledBooks = 0; // Total count of all untitled books to uniquely name them
    private String title;    //Book's title
    private String author;   //Book's author
    private String genre;    //Book's genre
    private int year;       //Year the book was published



    //Method to construct new Book object
    //---------------------------------------------------------------------------------------------
    //  Creates a new Book with everything specified.
    //---------------------------------------------------------------------------------------------
    //  Input: title  : String, book's title
    //         author : String, book's author
    //         year   : int,    year the book was published
    //         genre  : String, book's genre
    //
    //  Algorithm:
    //  Initialize Book's title to given title
    //  Initialize Book's year to given year
    //  Initialize Book's author to given author
    //  Initialize Book's genre to given genre
    //---------------------------------------------------------------------------------------------
    Book(String title, String author, int year, String genre) {
        setTitle(title);
        setYear(year);
        setAuthor(author);
        setGenre(genre);
    } //end constructor



    //Method to set Book's author
    //---------------------------------------------------------------------------------------------
    // Sets the book's author in Capital Case.
    //---------------------------------------------------------------------------------------------
    // Input: Name of the book's author : String
    // Output: New author's name : String
    //---------------------------------------------------------------------------------------------
    private String setAuthor(String author) {
        return (this.author = author);
    } //end method setAuthor

    //Method to set Book's genre
    //---------------------------------------------------------------------------------------------
    // Sets the book's genre in Capital Case.
    //---------------------------------------------------------------------------------------------
    // Input: Name of the book's genre : String
    //
    // Algorithm:
    // IF genre isn't given THEN
    //     Set to default genre
    // ELSE
    //     Set to specified genre capitalized
    // END IF
    //---------------------------------------------------------------------------------------------
    private String setGenre(String genre) {
        if (genre.length() == 0) {
            genre = DEFAULT_GENRE;
        }
        else {
            genre = capitalize(genre);
        }

        return (this.genre = genre);
    } //end method setGenre

    //Method to set Book's title
    //---------------------------------------------------------------------------------------------
    // Internally sets the Book's title in Title Case. If no title is specified, the title will be
    // uniquely named by using "Untitled #<next_book_number>" format.
    //---------------------------------------------------------------------------------------------
    // Input: New title to be used : String
    // Output: Book's new title name : String
    //
    // Algorithm:
    // IF title isn't given THEN
    //     Increment global counter of number of untitled books
    //     Set title to "Untitled #<next_book_number>"
    // ELSE
    //     Set title to given title in Title Case
    // END IF
    //---------------------------------------------------------------------------------------------
    private String setTitle(String title) {
        if (title.length() == 0) {
            untitledBooks++;
            title = "Untitled #" + untitledBooks;
        } //end if title isn't given
        else {
            title = titleCase(title);
        } //end else title is given

        return (this.title = title);
    } //end method setTitle

    //Method to set Book's number of year
    //---------------------------------------------------------------------------------------------
    // Sets the book's number of year.
    //---------------------------------------------------------------------------------------------
    // Input: Number of year in the book : Integer
    // Output: New number of year : Integer
    //
    // Algorithm:
    // IF year < 1 THEN
    //     Set year to 1
    // END IF
    //
    // Set Book's year to year value
    //---------------------------------------------------------------------------------------------
    private int setYear(int year) {
        if (year < 1) {
            year = 1;
        } //end if year is invalid

        return (this.year = year);
    } //end method setYear


    //Method to provide Book's author
    //---------------------------------------------------------------------------------------------
    // Provides the Book's author.
    //---------------------------------------------------------------------------------------------
    // Output: Table of Book's author : String
    //---------------------------------------------------------------------------------------------
    public String getAuthor() {
        return author;
    } //end method getAuthor

    //Method to provide Book's genre
    //---------------------------------------------------------------------------------------------
    // Provides the Book's genre.
    //---------------------------------------------------------------------------------------------
    // Output: Table of Book's genre : String
    //---------------------------------------------------------------------------------------------
    public String getGenre() {
        return genre;
    } //end method getGenre

    //Method to provide Book's title
    //---------------------------------------------------------------------------------------------
    // Provides the Book's title.
    //---------------------------------------------------------------------------------------------
    // Output: Table of Book's title : String
    //---------------------------------------------------------------------------------------------
    public String getTitle() {
        return title;
    } //end method getTitle

    //Method to provide Book's number of year
    //---------------------------------------------------------------------------------------------
    // Provides the Book's number of year.
    //---------------------------------------------------------------------------------------------
    // Output: Table of Book's number of year : Integer
    //---------------------------------------------------------------------------------------------
    public int getYear() {
        return year;
    } //end method getYear


    //Method to provide Book's details
    //---------------------------------------------------------------------------------------------
    // Provides a table of the Book's details.
    //---------------------------------------------------------------------------------------------
    // Output: Table of Book's details : String
    //---------------------------------------------------------------------------------------------
    public String displayDetails() {
        return "Title:  " + title + "\n"
             + "Author: " + author + "\n"
             + "Year:   " + year + "\n"
             + "Genre:  " + genre;
    } //end method displayDetails



    //Convert text to Title Case
    //---------------------------------------------------------------------------------------------
    //  Converts a string into Title Case. Certain words aren't capitalized per Chicago Manual of
    //  Style.
    //---------------------------------------------------------------------------------------------
    //  Input: Title to be converted : String
    //  Output: Title converted to Title Case : String
    //
    //  Algorithm:
    //  Split given title into an array of words (words)
    //  Initialize a string (ret) with the first word of str capitalized and a space
    //  Initialize current word counter (currentWord) to 1
    //
    //  FOR currentWord = 1 TO length of words array
    //      IF current word in the words is a title word THEN
    //          Add capitalized current word and a space
    //      ELSE
    //          Add word in lower case and a space
    //      END IF
    //  NEXT currentWord
    //
    //  IF there is more than one word THEN
    //      Capitalize first word
    //  END IF
    //
    //  Return ret with trimmed trailing spaces
    private static String titleCase(String str) {
        String[] words = str.split(" ");
        String ret;
        int currentWord;

        // Always capitalize first and last words, with other words in Title Case as needed
        ret = capitalize(words[0]) + " ";

        for (currentWord = 1; currentWord < (words.length - 1); currentWord++) {
            String word = words[currentWord];

            if (isTitleWord(word)) {
                ret += capitalize(word) + " ";
            } //end if title word
            else {
                ret += word.toLowerCase() + " ";
            } //end else not title word
        } //end for each word left

        if (words.length > 1) {
            ret += capitalize(words[currentWord]);
        } //end if there is more than one word

        return ret.trim();
    } //end method titleCase

    //Method to capitalize a word
    //--------------------------------------------------------------------------------------------
    // Converts every word into Capital Case.
    //--------------------------------------------------------------------------------------------
    // Input: Word to be capitalized : String
    // Output: Capitalized version of the word : String
    //--------------------------------------------------------------------------------------------
    private static String capitalize( String word ) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    } //end method capitalize

    //Method to see if word should be capitalized in title case
    //--------------------------------------------------------------------------------------------
    // Determines if a word should be capitalized when it's in a title,
    // per Chicago Manual of Style.
    //--------------------------------------------------------------------------------------------
    // Input: Word to check : String
    // Output: If word should be capitalized in title case : boolean
    //
    // Algorithm:
    // Initialize word to lower case version to be case insensitive
    // IF word is an article, coordinate conjunction or preposition THEN
    //     Return false
    // ELSE
    //     Return true
    // END IF
    //--------------------------------------------------------------------------------------------
    private static boolean isTitleWord( String word ) {
        boolean isCapitalized;
        word = word.toLowerCase();

        // All articles, coordinate conjunctions, and prepositions are lower case in titles,
        // per Chicago Manual of Style
        switch (word) {
            // Articles:
            case "a":       case "an":      case "the":
            // Coordinate conjunctions:
            case "and":     case "but":     case "for":     case "nor":     case "or":
            case "so":      case "yet":
            // Most common single-word English prepositions:
            case "at":      case "by":      case "in":      case "into":    case "near":
            case "of":      case "on":      case "to":      case "than":    case "via":
                isCapitalized = false;
                break;

            default:
                isCapitalized = true;
        } //end switch word

        return isCapitalized;
    } //end method isTitleWord


    //Method to represent Book object as a String
    //--------------------------------------------------------------------------------------------
    // Represents the class as a String, currently using the book's Title.
    //--------------------------------------------------------------------------------------------
    // Output: Book's title : String
    //--------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return getTitle();
    } //end method toString
} //end class Book
