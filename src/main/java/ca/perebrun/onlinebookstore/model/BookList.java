package ca.perebrun.onlinebookstore.model;

import java.util.List;

public class BookList {
    private List<Book> books;

    public java.util.List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
    public void removeBook(Book book) {
        books.remove(book);
    }
}
