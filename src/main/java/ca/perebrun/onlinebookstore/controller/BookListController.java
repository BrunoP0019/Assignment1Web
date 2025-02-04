package ca.perebrun.onlinebookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ca.perebrun.onlinebookstore.model.Book;
import ca.perebrun.onlinebookstore.model.BookList;

@Controller

public class BookListController {
    private final BookList bookList;

    public BookListController(BookList bookList) {
        this.bookList = bookList;
    }

    @GetMapping("/books")
    public String books(Model model) {
        model.addAttribute("books", bookList.getBooks());
        return "available_books";
    }

    // Add a new book (from form submission)
    @PostMapping("/books/add")
    public String addBook(@RequestParam String isbn,
                          @RequestParam String title,
                          @RequestParam String author,
                          @RequestParam Double price) {
        bookList.addBook(new Book(isbn, title, author, price));
        return "redirect:/books"; // Refreshes the page
    }


}
