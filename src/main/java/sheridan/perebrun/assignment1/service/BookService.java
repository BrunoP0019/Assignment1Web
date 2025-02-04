package sheridan.perebrun.assignment1.service;

import org.springframework.stereotype.Service;
import sheridan.perebrun.assignment1.model.Book;
import sheridan.perebrun.assignment1.model.BookList;

import java.util.List;

@Service
public class BookService {
    private final BookList bookList = new BookList();

    public BookService() {
        seedBooks();
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
        addBook(new Book("139516", "Introduction To Spring Boot", "Joshua Bloch", 15.56));
        addBook(new Book("718913", "Introduction to Spring MVC", "Cay S. Horstmann", 20.87));
        addBook(new Book("301903", "Introduction to C", "Katty Sierra", 25.00));
        addBook(new Book("379108", "Introduction to C++", "Bruce Eckel", 30.00));
        addBook(new Book("854891", "Introduction to Python", "Elisabeth Robson", 50.99));
        addBook(new Book("617930", "Introduction to HTML5", "Y. Daniel Liang", 60.00));
        addBook(new Book("219048", "Java For Beginners", "Eric Freeman", 70.43));
        addBook(new Book("582018", "HTML for Beginners", "Herbert Schidt", 80.90));
    }
}
