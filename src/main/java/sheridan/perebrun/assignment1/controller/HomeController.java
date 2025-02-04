package sheridan.perebrun.assignment1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // ✅ Handles the main homepage
    public String showHomePage() {
        return "index"; // ✅ Loads index.html from templates
    }
}
