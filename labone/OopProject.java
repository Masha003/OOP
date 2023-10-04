package labone;

public class OopProject {
    public static void main(String[] args){
        Book book = new Book("Atomic Habits", "James Clear", "Self-help book", 2018, "1234566543212");

        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getGenre());
        System.out.println(book.getisbn());

        book.getBookInfo();

    }
}
