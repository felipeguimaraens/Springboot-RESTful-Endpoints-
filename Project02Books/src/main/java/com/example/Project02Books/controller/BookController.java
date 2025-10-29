package com.example.Project02Books.controller;

import com.example.Project02Books.entity.Book;
import com.example.Project02Books.entity.BookRequest;
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

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
        return books.stream()
                .filter(book -> book.getId() == id)
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
    public void createBook(@RequestBody BookRequest bookRequest) {
        long id;
        if (books.isEmpty()) {
            id = 0;
        } else {
            id = books.get(books.size() - 1).getId();
        }

        Book book = convertToBook(id, bookRequest);
        books.add(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable long id, @RequestBody Book updatedBook) {
        for (int i = 0; i < books.size() ; i++) {
            if (books.get(i).getId() == id) {
                books.set(i, updatedBook);
                return ;
            }
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        books.removeIf(book -> book.getId() == id);
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

    private Book convertToBook(long id, BookRequest bookRequest) {
        return new Book(
                id, bookRequest.getTitle(), bookRequest.getAuthor(),
                bookRequest.getCategory(), bookRequest.getRating()
        );
    }

}
