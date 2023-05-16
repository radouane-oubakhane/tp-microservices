package com.khayati.product.ServiceProduct.Repository;

import com.khayati.product.ServiceProduct.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
