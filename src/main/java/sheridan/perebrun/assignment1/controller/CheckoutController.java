package sheridan.perebrun.assignment1.controller;

import jakarta.servlet.http.HttpServletRequest;
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
    public String showCheckoutPage(Model model, HttpServletRequest request) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("subtotal", cartService.calculateSubTotal());
        model.addAttribute("tax", cartService.calculateTax());
        model.addAttribute("total", cartService.calculateTotal());
        model.addAttribute("currentPage", request.getRequestURI());
        return "checkout";
    }
}


