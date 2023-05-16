package com.radouaneoubakhane.reviewservice.controller;


import com.radouaneoubakhane.reviewservice.dto.ReviewRequest;
import com.radouaneoubakhane.reviewservice.dto.ReviewResponse;
import com.radouaneoubakhane.reviewservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewResponse> getReviewById(@PathVariable int productId) {
        return reviewService.getReviewByProductId(productId);
    }

    @PostMapping("/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse createReview(@PathVariable int productId, @RequestBody ReviewRequest reviewRequest) {
        return reviewService.createReview(productId, reviewRequest);
    }

    @GetMapping("/{productId}/{reviewId}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewResponse getReviewById(@PathVariable int productId, @PathVariable Long reviewId) {
        return reviewService.getReviewById(productId, reviewId);
    }

    @PutMapping("/{productId}/{reviewId}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewResponse updateReview(@PathVariable int productId, @PathVariable Long reviewId,@RequestBody ReviewRequest reviewRequest) {
        return reviewService.updateReview(productId, reviewId, reviewRequest);
    }

    @DeleteMapping("/{productId}/{reviewId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable int productId , @PathVariable Long reviewId) {
        reviewService.deleteReview(productId, reviewId);
    }
}
