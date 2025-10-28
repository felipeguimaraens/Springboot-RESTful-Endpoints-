package com.example.Project01Books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/api-endpoint")
    public String firstApi() {
        return "Hello there!";
    }

}
