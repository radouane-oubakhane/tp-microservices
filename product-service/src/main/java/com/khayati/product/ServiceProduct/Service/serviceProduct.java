package com.khayati.product.ServiceProduct.Service;

import com.khayati.product.ServiceProduct.Model.Product;
import com.khayati.product.ServiceProduct.Repository.ProductRepository;
import com.khayati.product.ServiceProduct.dto.RequestProduct;
import com.khayati.product.ServiceProduct.dto.RespenseProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class serviceProduct implements ServiceInt{
    private final ProductRepository productRepository ;
    @Override
    public void saveProduct(RequestProduct requestProduct) {
        Product product = new Product();
        BeanUtils.copyProperties(requestProduct, product);
        productRepository.save(product);
        System.out.println("created with success !");
    }

    @Override
    public List<RespenseProduct> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<RespenseProduct> respenseProducts = new ArrayList<>();
        for (Product i : products) {
            RespenseProduct respense = RespenseProduct.builder()
                    .name(i.getName())
                    .weight(i.getWeight())
                    .build();
            respenseProducts.add(respense);
        }
        return respenseProducts;


    }

    @Override
    public RespenseProduct getProductById(int id) {

        RespenseProduct dto = RespenseProduct.builder().build();
        Product product=productRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        BeanUtils.copyProperties(product, dto);
        return dto;

    }

    @Override
    public RespenseProduct updateProduct(int id, RequestProduct requestProduct) {

        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("not found "));
        RespenseProduct dto = RespenseProduct.builder().build();
        BeanUtils.copyProperties(product, dto);
        if (requestProduct.getName() != null) dto.setName(requestProduct.getName());
        if (requestProduct.getWeight() != 0) dto.setWeight(requestProduct.getWeight());
        BeanUtils.copyProperties(dto, product);
        Product newProduct = productRepository.save(product);
        BeanUtils.copyProperties(newProduct, dto);
        return dto;
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
