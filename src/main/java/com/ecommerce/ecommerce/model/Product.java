package com.ecommerce.ecommerce.model;

//import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value = {"id", "buyPrice"})
@Entity
//@JsonFilter("dynamicMask")
public class Product implements java.io.Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private  int price;

    // Info sensible
    //@JsonIgnore
    private int zbuyPrice;

    public Product() {
    }

    public Product(int id, String name, int price, int buyPrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.zbuyPrice = buyPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBuyPrice() {
        return zbuyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.zbuyPrice = buyPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
