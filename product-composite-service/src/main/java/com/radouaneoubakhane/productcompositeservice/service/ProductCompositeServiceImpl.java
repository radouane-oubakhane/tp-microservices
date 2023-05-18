package com.radouaneoubakhane.productcompositeservice.service;

import com.radouaneoubakhane.productcompositeservice.dto.ProductResponse;
import com.radouaneoubakhane.productcompositeservice.dto.RecommendationResponse;
import com.radouaneoubakhane.productcompositeservice.dto.ReviewResponse;
import com.radouaneoubakhane.productcompositeservice.openfeingClients.ProductClient;
import com.radouaneoubakhane.productcompositeservice.openfeingClients.RecommendationClient;
import com.radouaneoubakhane.productcompositeservice.openfeingClients.ReviewClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductCompositeServiceImpl implements ProductCompositeService {

    private final ProductClient productClient;
    private final ReviewClient reviewClient;
    private final RecommendationClient recommendationClient;


    @CircuitBreaker(name = "productService", fallbackMethod = "getProductByIdFallback")
    public ProductResponse getProductById(int id) {
        return productClient.getProduct(id);
    }

    public ProductResponse getProductByIdFallback(int id, Exception exception) {
        return ProductResponse.builder()
                .id(id)
                .name("Fallback product")
                .weight(0)
                .build();
    }

    @CircuitBreaker(name = "reviewService", fallbackMethod = "getProductReviewsFallback")
    public List<ReviewResponse> getProductReviews(int id) {
        return reviewClient.getReviewsOfProduct(id);
    }

    public List<ReviewResponse> getProductReviewsFallback(int id, Exception exception) {
        return List.of(ReviewResponse.builder()
                .productId(id)
                .author("Fallback author")
                .subject("Fallback subject")
                .content("Fallback content")
                .build());
    }

    @CircuitBreaker(name = "recommendationService", fallbackMethod = "getProductRecommendationsFallback")
    public List<RecommendationResponse> getProductRecommendations(int id) {
        return recommendationClient.getRecommendationsOfProduct(id);
    }

    public List<RecommendationResponse> getProductRecommendationsFallback(int id, Exception exception) {
        return List.of(RecommendationResponse.builder()
                .productId(id)
                .author("Fallback author")
                .rate(0)
                .content("Fallback content")
                .build());
    }
}
