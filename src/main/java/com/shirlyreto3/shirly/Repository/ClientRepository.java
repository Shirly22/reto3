package com.shirlyreto3.shirly.Repository;

import com.shirlyreto3.shirly.Model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shirlyreto3.shirly.Repository.CRUD.ClientCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> findAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client client){
        return clientCrudRepository.save(client);
    }

    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
}
