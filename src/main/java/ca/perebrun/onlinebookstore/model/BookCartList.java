package ca.perebrun.onlinebookstore.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BookCartList extends BookList {
    private List<Book> cartBooks = new ArrayList<>();

    public void addToCart(Book book) {
        cartBooks.add(book);
    }

    public void removeFromCart(Book book) {
        cartBooks.remove(book);
    }

}
