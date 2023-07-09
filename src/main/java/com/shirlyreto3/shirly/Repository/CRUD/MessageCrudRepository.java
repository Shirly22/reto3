package com.shirlyreto3.shirly.Repository.CRUD;

import com.shirlyreto3.shirly.Model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
