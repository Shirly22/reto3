package com.shirlyreto3.shirly.Service;

import com.shirlyreto3.shirly.Model.Car;
import com.shirlyreto3.shirly.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll(){
        return (List<Car>) carRepository.findAll();
    }

    public Optional<Car> getCar(int id){
        return carRepository.getCar(id);
    }

    public Car save(Car car){
        if(car.getIdCar() == null){
            return carRepository.save(car);
        } else {
            Optional<Car> carFound = getCar(car.getIdCar());
            if(carFound.isPresent()){
                return carRepository.save(car);
            } else {
                return car;
            }
        }

    }

    public Car update(Car car){
        if(car.getIdCar() != null){
            Optional<Car> carFound = getCar(car.getIdCar());
            if (carFound.isPresent()){
                if(car.getBrand() != null){
                    carFound.get().setBrand(car.getBrand());
                }
                if(car.getName() != null){
                    carFound.get().setName(car.getName());
                }
                if (car.getGama() != null){
                    carFound.get().setGama(car.getGama());
                }
                if (car.getYear() != null){
                    carFound.get().setYear(car.getYear());
                }
                if (car.getDescription() != null){
                    carFound.get().setDescription(car.getDescription());
                }
                if (car.getMessages() != null){
                    carFound.get().setMessages(car.getMessages());
                }

                return carRepository.save(carFound.get());
            } else {
                return car;
            }
        } else {
            return car;
        }
    }

    public boolean deleteCar(int id){
        Boolean respuesta = getCar(id).map( car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
        return respuesta;
    }
}




