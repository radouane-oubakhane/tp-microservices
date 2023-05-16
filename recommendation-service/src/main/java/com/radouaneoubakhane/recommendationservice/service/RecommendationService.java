package com.radouaneoubakhane.recommendationservice.service;


import com.radouaneoubakhane.recommendationservice.dto.RecommendationRequest;
import com.radouaneoubakhane.recommendationservice.dto.RecommendationResponse;
import com.radouaneoubakhane.recommendationservice.exception.RecommendationNotFoundException;
import com.radouaneoubakhane.recommendationservice.model.Recommendation;
import com.radouaneoubakhane.recommendationservice.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RecommendationService {

    public List<RecommendationResponse> getRecommendationByProductId(int productId);

    public RecommendationResponse createRecommendation(int productId, RecommendationRequest recommendationRequest);

    public RecommendationResponse updateRecommendation(int productId, Long recommendationId, RecommendationRequest recommendationRequest);

    public void deleteRecommendation(int productId, Long recommendationId);

    public RecommendationResponse getRecommendationById(int productId, Long recommendationId);
}
