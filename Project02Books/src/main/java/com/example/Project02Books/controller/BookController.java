package com.example.Project02Books.controller;

import com.example.Project02Books.entity.Book;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private List<Book> books = new ArrayList<>();

    public BookController() {
        initializeBooks();
    }

    @GetMapping("/{title}")
    public Book getBookByTitle(@PathVariable String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    @GetMapping
    public List<Book> getBooks(@RequestParam(required = false) String category) {
        if (category == null) {
            return books;
        }

        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    @PostMapping
    public void createBook(@RequestBody Book newBook) {
        boolean isNewBook = books
                .stream()
                .noneMatch(book -> book.getTitle().equalsIgnoreCase(newBook.getTitle()));

        if (isNewBook) {
            books.add(newBook);
        }
    }

    @PutMapping("/{title}")
    public void updateBook(@PathVariable String title, @RequestBody Book updatedBook) {
        for (int i = 0; i < books.size() ; i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.set(i, updatedBook);
                return ;
            }
        }
    }

    @DeleteMapping("/{title}")
    public void deleteBook(@PathVariable String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    private void initializeBooks() {
        books.addAll(List.of(
                new Book(0, "Game Programming in C++", "Sanjay Madhav", "Educational", 10),
                new Book(1, "I, Robot", "Isaac Asimov", "Science Fiction", 9),
                new Book(2, "The Bicentennial Man", "Isaac Asimov", "Science Fiction", 7),
                new Book(3, "Neuromancer", "William Gibson", "Science Fiction", 8),
                new Book(4, "Game Programming Algorithms and Techniques", "Sanjay Madhav", "Educational", 9),
                new Book(5, "Game Programming Patterns", "Robert Nystrom", "Educational", 8)
        ));
    }

}
