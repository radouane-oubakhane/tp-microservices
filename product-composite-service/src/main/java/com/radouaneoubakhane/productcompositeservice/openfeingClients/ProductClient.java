package com.radouaneoubakhane.productcompositeservice.openfeingClients;


import com.radouaneoubakhane.productcompositeservice.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="api-gateway/product-service")
public interface ProductClient {
    @GetMapping(value = "/api/products/{id}", produces = "application/json")
    ProductResponse getProduct(@PathVariable int id);
}
