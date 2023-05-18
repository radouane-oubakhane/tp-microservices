package com.radouaneoubakhane.productcompositeservice.openfeingClients;


import com.radouaneoubakhane.productcompositeservice.dto.ReviewResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "api-gateway/review-service")
public interface ReviewClient {
    @GetMapping(value = "/api/reviews/{productId}", produces = "application/json")
    List<ReviewResponse> getReviewsOfProduct(@PathVariable int productId);
}
