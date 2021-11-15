package digital.and.bootcamp.surverycreator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CreateController {

    @GetMapping("/test")
    public String testEndpoint() {
        return "Hello" + UUID.randomUUID().toString();
    }
}
