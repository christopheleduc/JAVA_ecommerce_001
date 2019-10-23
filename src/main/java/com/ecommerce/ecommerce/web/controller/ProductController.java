package com.ecommerce.ecommerce.web.controller;

import com.ecommerce.ecommerce.dao.ProductDao;
import com.ecommerce.ecommerce.model.Product;
import java.net.URI;
import java.util.List;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
//import javafx.beans.property.SimpleBooleanProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import javax.xml.ws.Response;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    // Liste des produits
    @RequestMapping( value= "/Products", method=RequestMethod.GET )
    //public String listingProducts() {
    //public List<Product> listingProducts() {
    public MappingJacksonValue listingProducts() {

        Iterable<Product> products = productDao.findAll();
        //List<Product> products = productDao.findAll();

        SimpleBeanPropertyFilter myMask = SimpleBeanPropertyFilter.serializeAllExcept("buyPrice", "id");

        FilterProvider listMasks = new SimpleFilterProvider().addFilter("dynamicMask", myMask);
        MappingJacksonValue productsMask = new MappingJacksonValue(products);
        productsMask.setFilters(listMasks);

        return productsMask;
        //return "A exemple of a product";
        //return productDao.findAll();
    }

    // Produit par ID
    @GetMapping(value = "/Products/{id}")
    public Product showProduct( @PathVariable int id ) {
        //Product product = new Product ( id, new String("Aspirateur"), 100 );
        //return product;
        return productDao.findById(id);
    }

    @GetMapping(value = "test/products/{priceLimit}")
    public List<Product> rockettesTest(@PathVariable int priceLimit) {
        return productDao.findByPriceGreaterThan(400);
    }

    @GetMapping(value = "test/produits/{search}")
    public List<Product> rockettesSearch(@PathVariable String search) {
        return productDao.findByNameLike("%"+search+"%");
    }

    //ajouter un produit
    @PostMapping(value = "/Products")
    public ResponseEntity<Void> addProduct(@RequestBody Product product) {

        Product productAdded = productDao.save(product);
        if (productAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    //public void addProduct(@RequestBody Product product) {
        //productDao.save(product);
    }

    @DeleteMapping (value = "/Products/{id}")
    public void delProduct(@PathVariable int id) {

        productDao.deleteById(id);
    }

    @PutMapping (value = "/Products")
    public void updateProduct(@RequestBody Product product) {

        productDao.save(product);
    }
}

