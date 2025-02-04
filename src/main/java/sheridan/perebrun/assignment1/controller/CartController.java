package sheridan.perebrun.assignment1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sheridan.perebrun.assignment1.model.Book;
import sheridan.perebrun.assignment1.service.BookService;
import sheridan.perebrun.assignment1.service.CartService;

@Controller
public class CartController {
    private final CartService cartService;
    private final BookService bookService;

    public CartController(CartService cartService, BookService bookService) {
        this.cartService = cartService;
        this.bookService = bookService;
    }

    @GetMapping("/cart")
    public String showCart(Model model, HttpServletRequest request) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("cartCount", cartService.getCartSize());
        model.addAttribute("currentPage", request.getRequestURI());
        return "shopping_cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam String isbn) {
        Book book = bookService.getBookByISBN(isbn);
        if (book != null) {
            cartService.addToCart(book);
        }
        return "redirect:/cart";
    }
}


