package com.example.springbootlibrary.requestmodels;

import java.util.Optional;

public class ReviewRequest {
    private double rating;
    private Long bookId;
    private Optional<String> description;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Optional<String> getDescription() {
        return description;
    }

    public void setDescription(Optional<String> description) {
        this.description = description;
    }
}
