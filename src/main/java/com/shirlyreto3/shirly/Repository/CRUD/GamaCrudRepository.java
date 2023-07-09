package com.shirlyreto3.shirly.Repository.CRUD;

import com.shirlyreto3.shirly.Model.Gama;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GamaCrudRepository extends CrudRepository<Gama,Integer> {
}
