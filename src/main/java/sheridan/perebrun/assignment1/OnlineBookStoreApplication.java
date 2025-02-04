package sheridan.perebrun.assignment1; // ✅ Ensure this matches your actual package

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // ✅ Ensures Spring Boot scans the whole package
public class OnlineBookStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineBookStoreApplication.class, args);
    }
}

