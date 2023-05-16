package com.khayati.product.ServiceProduct.Controller;

import com.khayati.product.ServiceProduct.Service.serviceProduct;
import com.khayati.product.ServiceProduct.dto.RequestProduct;
import com.khayati.product.ServiceProduct.dto.RespenseProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final serviceProduct serviceProduct;

    @PostMapping
    public void saveProduct(@RequestBody RequestProduct requestProduct){
        serviceProduct.saveProduct(requestProduct);
    }
    @GetMapping
    public List<RespenseProduct> getAllProducts(){
        return serviceProduct.getAllProducts();
    }
    @GetMapping("/{id}")
    public RespenseProduct getProduct(@PathVariable("id") int id ){
        return serviceProduct.getProductById(id);
    }
    @PutMapping("/{id}")
    public RespenseProduct updateProduct(@PathVariable("id") int id ,@RequestBody RequestProduct requestProduct){
        return serviceProduct.updateProduct(id,requestProduct);
    }
    @DeleteMapping
    public void deleteProduct(int id){
        serviceProduct.deleteProduct(id);
    }


}
