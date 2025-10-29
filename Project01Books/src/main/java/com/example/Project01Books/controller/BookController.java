package com.example.Project01Books.controller;

import com.example.Project01Books.entity.Book;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private List<Book> books = new ArrayList<>();

    public BookController() {
        initializeBooks();
    }

    @GetMapping("/api/books/title/{title}")
    public Book getBookByTitle(@PathVariable String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String category) {
        if (category == null) {
            return books;
        }

        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    private void initializeBooks() {
        books.addAll(List.of(
                new Book("Game Programming in C++", "Sanjay Madhav", "Educational"),
                new Book("I, Robot", "Isaac Asimov", "Science Fiction"),
                new Book("The Bicentennial Man", "Isaac Asimov", "Science Fiction"),
                new Book("Neuromancer", "William Gibson", "Science Fiction"),
                new Book("Game Programming Algorithms and Techniques", "Sanjay Madhav", "Educational"),
                new Book("Game Programming Patterns", "Robert Nystrom", "Educational")
        ));
    }

}
