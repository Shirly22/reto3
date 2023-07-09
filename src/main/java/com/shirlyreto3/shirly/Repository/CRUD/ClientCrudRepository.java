package com.shirlyreto3.shirly.Repository.CRUD;

import com.shirlyreto3.shirly.Model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClientCrudRepository extends CrudRepository<Client,Integer> {
}
