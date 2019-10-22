package com.ecommerce.ecommerce.dao;

import com.ecommerce.ecommerce.model.Product;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface ProductDao {
    public List<Product>findAll();
    public Product findById ( int id );
    public Product save ( Product product );
}
