package sheridan.perebrun.assignment1.service;


import org.springframework.stereotype.Service;
import sheridan.perebrun.assignment1.model.Book;
import sheridan.perebrun.assignment1.model.BookCartList;

import java.util.List;

@Service
public class CartService {
    private final BookCartList cart = new BookCartList();

    public void addToCart(Book book) {
        cart.addToCart(book);
    }

    public void removeFromCart(Book book) {
        cart.removeFromCart(book);
    }

    public List<Book> getCartItems() {
        return cart.getCartBooks(); // Returns the list of books
    }

    public double calculateSubTotal(List<Book> books) {
        double subtotal = 0;
        for (Book book : books) {
            subtotal += book.getPrice();
        }
        return subtotal;
    }
    public double calculateTotal(List<Book> books) {
        double subtotal = calculateSubTotal(books);
        return subtotal + (subtotal * 0.13);
    }

}
