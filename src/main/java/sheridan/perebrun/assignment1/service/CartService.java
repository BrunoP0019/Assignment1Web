package sheridan.perebrun.assignment1.service;

import org.springframework.stereotype.Service;
import sheridan.perebrun.assignment1.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

@Service
public class CartService {
    private final List<Book> cartBooks = new ArrayList<>();
    private final DecimalFormat df = new DecimalFormat("0.00");

    public void addToCart(Book book) {
        if (!cartBooks.contains(book)) {
            cartBooks.add(book);
        }
    }

    public List<Book> getCartItems() {
        return cartBooks;
    }

    public int getCartSize() {
        return cartBooks.size();
    }

    public double calculateSubTotal() {
        return cartBooks.stream().mapToDouble(Book::getPrice).sum();
    }

    public String calculateTax() {
        return df.format(calculateSubTotal() * 0.13);
    }

    public String calculateTotal() {
        return df.format(calculateSubTotal() + Double.parseDouble(calculateTax()));
    }
}

