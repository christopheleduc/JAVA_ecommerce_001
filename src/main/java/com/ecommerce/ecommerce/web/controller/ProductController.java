package com.ecommerce.ecommerce.web.controller;
import com.ecommerce.ecommerce.model.Product;
import java.lang.String;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @RequestMapping( value= "/Products", method=RequestMethod.GET )
    public String listingProducts() {
        return "A exemple of a product";
    }

    @GetMapping(value = "/Products/{id}")
    public Product showProduct( @PathVariable int id ) {
        Product product = new Product ( id, new String("Aspirateur"), 100 );
        return product;
    }
}

