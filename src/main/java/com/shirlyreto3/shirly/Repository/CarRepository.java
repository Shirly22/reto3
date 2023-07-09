package com.shirlyreto3.shirly.Repository;

import com.shirlyreto3.shirly.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shirlyreto3.shirly.Repository.CRUD.CarCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {
    @Autowired
    private CarCrudRepository carCrudRepository;

    public List<Car> findAll(){
        return (List<Car>) carCrudRepository.findAll();
    }

    public Optional<Car> getCar(int id){
        return carCrudRepository.findById(id);
    }

    public Car save(Car car){
        return carCrudRepository.save(car);
    }

    public void delete(Car car){
        carCrudRepository.delete(car);
    }
}
