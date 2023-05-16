package com.radouaneoubakhane.productcompositeservice.service;

import com.radouaneoubakhane.productcompositeservice.dto.ProductResponse;
import com.radouaneoubakhane.productcompositeservice.dto.RecommendationResponse;
import com.radouaneoubakhane.productcompositeservice.dto.ReviewResponse;
import com.radouaneoubakhane.productcompositeservice.openfeingClients.ProductClient;
import com.radouaneoubakhane.productcompositeservice.openfeingClients.RecommendationClient;
import com.radouaneoubakhane.productcompositeservice.openfeingClients.ReviewClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductCompositeServiceImpl implements ProductCompositeService {

    private final ProductClient productClient;
    private final ReviewClient reviewClient;
    private final RecommendationClient recommendationClient;


    public ProductResponse getProductById(int id) {
        return productClient.getProduct(id);
    }

    public List<ReviewResponse> getProductReviews(int id) {
        return reviewClient.getReviewsOfProduct(id);
    }

    public List<RecommendationResponse> getProductRecommendations(int id) {
        return recommendationClient.getRecommendationsOfProduct(id);
    }
}
