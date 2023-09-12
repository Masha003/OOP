package ooplabs;

public class Book {
    // instance variables
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private String ISBN;

    // constructor declaration of class
    public Book(String title, String author, String genre, int publicationYear, String ISBN){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getGenre(){
        return genre;
    }

    public int getPublicationYear(){
        return publicationYear;
    }

    public String getISBN(){
        return ISBN;
    }

    public String getBookInfo(){
        return "Title: " + title + "\nAuthor: " + author + "\nGenre: " + genre + "\nPublished: " + publicationYear + "\nISBN: " + ISBN;
    }

}
