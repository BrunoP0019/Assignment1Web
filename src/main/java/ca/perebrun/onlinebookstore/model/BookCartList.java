package ca.perebrun.onlinebookstore.model;

import java.util.List;

public class BookCartList extends BookList {
    public double calculateSubTotal(){
        double subtotal = 0;
        for (int i = 0; i < getBooks().size(); i++) {
            subtotal += getBooks().get(i).getPrice();
        }
        return subtotal;
    }
    public double calculateTotal(){
        return calculateSubTotal() + calculateSubTotal() * 0.13;
    }
}
