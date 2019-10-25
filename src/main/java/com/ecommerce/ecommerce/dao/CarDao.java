package com.ecommerce.ecommerce.dao;

import com.ecommerce.ecommerce.model.Car;
import com.ecommerce.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarDao extends JpaRepository<Car, Integer> {
    Car findById(int id);
    List<Product> findByCarNameLike(String search);
}
