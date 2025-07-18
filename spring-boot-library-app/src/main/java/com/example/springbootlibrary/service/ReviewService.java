package com.example.springbootlibrary.service;

import com.example.springbootlibrary.dao.ReviewRepository;
import com.example.springbootlibrary.entity.Review;
import com.example.springbootlibrary.requestmodels.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

@Service
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void postReview(String userEmail, ReviewRequest reviewRequest){
        Review validateReview = reviewRepository.findByUserEmailAndBookId(userEmail,reviewRequest.getBookId());
        if (validateReview != null){
            throw new Error("Review already created");
        }
        Review review = new Review();
        review.setBookId(reviewRequest.getBookId());
        review.setRating(reviewRequest.getRating());
        review.setUserEmail(userEmail);

        if(reviewRequest.getDescription().isPresent()){
            review.setReviewDescription(reviewRequest.getDescription().map(
                    Object::toString
            ).orElse(null));
        }
        review.setDate(Date.valueOf(LocalDate.now()));
        reviewRepository.save(review);
    }

    public Boolean userReviewListed(String userEmail,Long bookId){
        Review validateReview = reviewRepository.findByUserEmailAndBookId(userEmail,bookId);
        return validateReview != null;
    }
}
