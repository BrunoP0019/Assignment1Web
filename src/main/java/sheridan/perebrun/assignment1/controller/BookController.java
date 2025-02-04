package sheridan.perebrun.assignment1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sheridan.perebrun.assignment1.model.Book;
import sheridan.perebrun.assignment1.service.BookService;
import java.util.Random;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books") // ✅ Ensures the /books route exists
    public String showBooks(Model model,  HttpServletRequest request) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("currentPage", request.getRequestURI());
        return "available_books"; // ✅ Must match available_books.html in templates
    }

    @PostMapping("/books/add") // ✅ Handles adding books
    public String addBook(
                          @RequestParam String title,
                          @RequestParam String author,
                          @RequestParam Double price) {
        Random random = new Random();
        int randIsbn = random.nextInt(100000,1000000);
        bookService.addBook(new Book(String.valueOf(randIsbn), title, author, price));
        return "redirect:/books"; // ✅ Refreshes the page
    }
}


