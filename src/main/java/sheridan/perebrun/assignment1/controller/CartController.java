package sheridan.perebrun.assignment1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sheridan.perebrun.assignment1.model.Book;
import sheridan.perebrun.assignment1.service.CartService;
import sheridan.perebrun.assignment1.service.BookService;

import java.util.List;

@Controller
public class CartController {
    private final CartService cartService;
    private final BookService bookService;

    public CartController(CartService cartService, BookService bookService) {
        this.cartService = cartService;
        this.bookService = bookService;
    }

    @GetMapping("/cart") // ✅ Route to show the shopping cart
    public String showCart(Model model, HttpServletRequest request) {
        List<Book> cartItems = cartService.getCartItems();
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("subtotal", cartService.calculateSubTotal(cartItems)); // ✅ Passes book list
        model.addAttribute("total", cartService.calculateTotal(cartItems));
        model.addAttribute("currentPage", request.getRequestURI());// ✅ Passes book list
        return "shopping_cart"; // ✅ Must match shopping_cart.html in templates
    }

    @PostMapping("/cart/add") // ✅ Route to add a book to the cart
    public String addToCart(@RequestParam String isbn) {
        Book book = bookService.getBookByISBN(isbn);
        if (book != null) {
            cartService.addToCart(book);
        }
        return "redirect:/cart"; // ✅ Redirects to cart page after adding
    }

    @PostMapping("/cart/remove") // ✅ Route to remove a book from the cart
    public String removeFromCart(@RequestParam String isbn) {
        Book book = bookService.getBookByISBN(isbn);
        if (book != null) {
            cartService.removeFromCart(book);
        }
        return "redirect:/cart"; // ✅ Redirects to cart page after removing
    }
}
