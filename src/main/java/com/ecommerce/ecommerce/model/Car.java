package com.ecommerce.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String carName;

    @Column(nullable = false)
    private String modelName;

    public Car() {

    }

    public Car(int id, String carName, String modelName) {
        this.id = id;
        this.carName = carName;
        this.modelName = modelName;
    }

    public int getId() {
        return id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", modelle='" + carName + '\'' +
                ", marque=" + modelName +
                '}';
    }
}
