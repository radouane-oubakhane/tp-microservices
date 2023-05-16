package com.khayati.product.ServiceProduct.Service;

import com.khayati.product.ServiceProduct.dto.RequestProduct;
import com.khayati.product.ServiceProduct.dto.RespenseProduct;

import java.util.List;

public interface ServiceInt {
    public void saveProduct(RequestProduct requestProduct);
    List<RespenseProduct> getAllProducts();
    RespenseProduct getProductById(int id);
    RespenseProduct updateProduct(int id, RequestProduct requestProduct);
    void deleteProduct(int id);

}
