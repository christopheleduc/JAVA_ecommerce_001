package com.ecommerce.ecommerce.dao;

import com.ecommerce.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    Product findById(int id);
    List<Product> findByPriceGreaterThan(int priceLimit);
    List<Product> findByNameLike(String search);
//    public List<Product>findAll();
//    public Product findById ( int id );
//    public Product save ( Product product );
}
