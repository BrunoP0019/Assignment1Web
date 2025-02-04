package ca.perebrun.onlinebookstore.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String bookISBN;
    private String bookTitle;
    private String bookAuthor;
    private double price;

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }
}
