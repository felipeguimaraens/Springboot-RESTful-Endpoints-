package com.example.Project02Books.entity;

import jakarta.validation.constraints.*;

public class BookRequest {
    @Size(min=1, max=30)
    private String title;
    @Size(min=1, max=40)
    private String author;
    @Size(min=1, max=30)
    private String category;
    @Min(value=1)
    @Max(value=5)
    private int rating;

    public BookRequest(String title, String author, String category, int rating) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
