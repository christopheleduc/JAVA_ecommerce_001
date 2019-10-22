package com.ecommerce.ecommerce.web.controller;

import com.ecommerce.ecommerce.dao.ProductDao;
import com.ecommerce.ecommerce.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    // Liste des produits
    @RequestMapping( value= "/Products", method=RequestMethod.GET )
    //public String listingProducts() {
    public List<Product> listingProducts() {
        //return "A exemple of a product";
        return productDao.findAll();
    }

    // Produit par ID
    @GetMapping(value = "/Products/{id}")
    public Product showProduct( @PathVariable int id ) {
        //Product product = new Product ( id, new String("Aspirateur"), 100 );
        //return product;
        return productDao.findById(id);
    }
}

