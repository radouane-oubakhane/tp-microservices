package com.radouaneoubakhane.reviewservice.service;

import com.radouaneoubakhane.reviewservice.dto.ReviewRequest;
import com.radouaneoubakhane.reviewservice.dto.ReviewResponse;
import com.radouaneoubakhane.reviewservice.exception.ReviewNotFoundException;
import com.radouaneoubakhane.reviewservice.model.Review;
import com.radouaneoubakhane.reviewservice.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReviewService {
    public List<ReviewResponse> getReviewByProductId(int productId);

    public ReviewResponse createReview(int productId, ReviewRequest reviewRequest);


    public ReviewResponse updateReview(int productId, Long reviewId, ReviewRequest reviewRequest);

    public void deleteReview(int productId, Long reviewId);

    public ReviewResponse getReviewById(int productId, Long reviewId);
}
