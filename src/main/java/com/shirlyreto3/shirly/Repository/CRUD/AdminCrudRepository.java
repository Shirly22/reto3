package com.shirlyreto3.shirly.Repository.CRUD;

import com.shirlyreto3.shirly.Model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AdminCrudRepository extends CrudRepository<Admin,Integer> {
}
