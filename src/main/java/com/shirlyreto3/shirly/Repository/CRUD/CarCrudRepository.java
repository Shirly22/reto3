package com.shirlyreto3.shirly.Repository.CRUD;

import com.shirlyreto3.shirly.Model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CarCrudRepository extends CrudRepository<Car,Integer> {
}
