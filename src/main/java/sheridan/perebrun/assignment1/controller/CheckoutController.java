package sheridan.perebrun.assignment1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sheridan.perebrun.assignment1.service.CartService;

@Controller
public class CheckoutController {
    private final CartService cartService;

    public CheckoutController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/checkout")
    public String showCheckoutPage(Model model) {
        model.addAttribute("subtotal", cartService.calculateSubTotal(cartService.getCartItems()));
        model.addAttribute("total", cartService.calculateTotal(cartService.getCartItems()));
        return "checkout";
    }

}

