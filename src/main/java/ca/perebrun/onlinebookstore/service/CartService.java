package ca.perebrun.onlinebookstore.service;

import ca.perebrun.onlinebookstore.model.Book;

import java.util.List;

public class CartService {
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
