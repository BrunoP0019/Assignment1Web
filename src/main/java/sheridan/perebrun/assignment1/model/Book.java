package sheridan.perebrun.assignment1.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String isbn;
    private String title;
    private String author;
    private double price;

}
