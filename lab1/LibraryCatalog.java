package ooplabs.lab1;

import java.util.ArrayList;

public class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog(){
        books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }
    
    public void removeBook(String ISBN){
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
            System.out.println();
        }
    }

    public Book searchByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }
}
