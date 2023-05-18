package com.radouaneoubakhane.productcompositeservice.openfeingClients;


import com.radouaneoubakhane.productcompositeservice.dto.RecommendationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "api-gateway/recommendation-service")
public interface RecommendationClient {
    @GetMapping(value = "/api/recommendations/{productId}", produces = "application/json")
    List<RecommendationResponse> getRecommendationsOfProduct(@PathVariable int productId);
}
