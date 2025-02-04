package sheridan.perebrun.assignment1.service;

import org.springframework.stereotype.Service;
import sheridan.perebrun.assignment1.model.Book;
import sheridan.perebrun.assignment1.model.BookList;

import java.util.List;

@Service
public class BookService {
    private final BookList bookList = new BookList(); // Internal book list

    public BookService() {
        seedBooks(); // Load some initial books
    }

    public void addBook(Book book) {
        bookList.addBook(book);
    }

    public List<Book> getAllBooks() {
        return bookList.getBooks();
    }

    public Book getBookByISBN(String isbn) {
        return bookList.getBooks().stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    private void seedBooks() {
        addBook(new Book("123456", "Java Basics", "John Doe", 39.99));
        addBook(new Book("234567", "Spring Boot Guide", "Jane Smith", 49.99));
    }
}
