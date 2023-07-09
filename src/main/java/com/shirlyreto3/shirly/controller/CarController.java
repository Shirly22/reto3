package com.shirlyreto3.shirly.controller;

import com.shirlyreto3.shirly.Model.Car;

import com.shirlyreto3.shirly.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", methods={RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/all")
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable int id) {
        return carService.getCar(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Car car) {
        carService.save(car);
    }
}





