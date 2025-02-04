package sheridan.perebrun.assignment1.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BookCartList extends BookList {
    private final List<Book> cartBooks = new ArrayList<>();

    public void addToCart(Book book) {
        cartBooks.add(book);
    }

    public void removeFromCart(Book book) {
        cartBooks.remove(book);
    }


}
