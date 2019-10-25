package com.ecommerce.ecommerce.web.controller;

import java.net.URI;
//import java.util.List;
import com.ecommerce.ecommerce.dao.CarDao;
import com.ecommerce.ecommerce.model.Car;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Api( description = "API pour les opérations CRUD sur les voitures")
@RestController
public class CarController {

    @Autowired
    private CarDao carDao;

    // Liste des voitures
    @ApiOperation(value = "Récupère une liste de voitures !")
    @RequestMapping( value= "/Cars", method=RequestMethod.GET )
    //public String listingProducts() {
    //public List<Product> listingProducts() {
    public MappingJacksonValue listingCars() {

        Iterable<Car> cars = carDao.findAll();
        //List<Product> products = productDao.findAll();

        SimpleBeanPropertyFilter myMask = SimpleBeanPropertyFilter.serializeAllExcept("id");

        FilterProvider listMasks = new SimpleFilterProvider().addFilter("dynamicMask", myMask);
        MappingJacksonValue carsMask = new MappingJacksonValue(cars);
        carsMask.setFilters(listMasks);

        return carsMask;
        //return carDao.findAll();
    }

    // Car par ID
    @ApiOperation(value = "Récupère une voiture grâce à son ID à condition que celui-ci existe!")
    @GetMapping(value = "/Cars/{id}")
    public Car showCar( @PathVariable int id ) {
        return carDao.findById(id);
    }

    //ajouter une voiture
    @ApiOperation(value = "Permet d'jouter une voiture à la liste !")
    @PostMapping(value = "/Cars")
    public ResponseEntity<Void> addCar(@RequestBody Car car) {

        Car carAdded = carDao.save(car);
        if (carAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Permet de supprimer une voiture de la liste !")
    @DeleteMapping (value = "/Cars/{id}")
    public void delCar(@PathVariable int id) {

        carDao.deleteById(id);
    }

    @ApiOperation(value = "Permet de modifier une voiture dans la liste !")
    @PutMapping (value = "/Cars")
    public void updateCar(@RequestBody Car car) {

        carDao.save(car);
    }
}
