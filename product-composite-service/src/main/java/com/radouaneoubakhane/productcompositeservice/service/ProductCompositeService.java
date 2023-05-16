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



public interface ProductCompositeService {

    public ProductResponse getProductById(int id);

    public List<ReviewResponse> getProductReviews(int id);

    public List<RecommendationResponse> getProductRecommendations(int id);
}
