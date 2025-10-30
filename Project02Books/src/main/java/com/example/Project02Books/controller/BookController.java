package com.example.Project02Books.controller;

import com.example.Project02Books.entity.Book;
import com.example.Project02Books.entity.BookRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name="SpringBooks - Books API", description="Collection of APIs to operate books")
@RestController
@RequestMapping("/api/books")
public class BookController {
    private List<Book> books = new ArrayList<>();

    public BookController() {
        initializeBooks();
    }

    @Operation(summary="Get book by id", description="Retrieve a book by id")
    @GetMapping("/{id}")
    public Book getBookById(@Parameter(description="Optional query parameter")
                                @PathVariable @Min(value = 0) long id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Operation(summary="Get books by category", description="Get all books within same category")
    @GetMapping
    public List<Book> getBooks(@Parameter(description="Category of book to be retrieved")
                                   @RequestParam(required = false) String category) {
        if (category == null) {
            return books;
        }

        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    @Operation(summary="Create a book", description="Create a new book")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createBook(@RequestBody BookRequest bookRequest) {
        long id = books.isEmpty()? 0 : books.getLast().getId() + 1;

        Book book = convertToBook(id, bookRequest);

        books.add(book);
    }

    @Operation(summary="Update book", description="Update a book by id")
    @PutMapping("/{id}")
    public void updateBook(@Parameter(description="Id of book to be updated")
            @PathVariable @Min(value = 0) long id, @RequestBody BookRequest bookRequest) {
        for (int i = 0; i < books.size() ; i++) {
            if (books.get(i).getId() == id) {
                Book updatedBook = convertToBook(id, bookRequest);
                books.set(i, updatedBook);
                return ;
            }
        }
    }

    @Operation(summary="Delete book", description="Delete a book by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteBook(@Parameter(description="Id of book to be deleted")
            @PathVariable @Min(value = 0) long id) {
        books.removeIf(book -> book.getId() == id);
    }

    @Operation(summary="404 dummy page", description="Just return 404 as test")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/resource-not-found")
    public void resourceNotFound() {
        // Logic that returns a resource not found
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
