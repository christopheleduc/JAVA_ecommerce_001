package com.ecommerce.ecommerce.dao;

import com.ecommerce.ecommerce.model.Product;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    public static List<Product>products = new ArrayList<>();
    static {
        products.add(new Product(1, new String("Ordinateur portable"), 350, 120));
        products.add(new Product(2, new String("Aspirateur robot"), 500, 200));
        products.add(new Product(3, new String("Table de ping pong"), 750, 400));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}
