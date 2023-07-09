package com.shirlyreto3.shirly.Service;

import com.shirlyreto3.shirly.Model.Client;
import com.shirlyreto3.shirly.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    public List<Client> getAll(){
        return (List<Client>) clientRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client client){
        if(client.getIdClient() == null){
            return clientRepository.save(client);
        } else {
            Optional<Client> carFound = getClient(client.getIdClient());
            if(carFound.isPresent()){
                return clientRepository.save(client);
            } else {
                return client;
            }
        }

    }

    public Client update(Client client){
        if(client.getIdClient() != null){
            Optional<Client> clientFound = getClient(client.getIdClient());
            if (clientFound.isPresent()){
                if(client.getEmail() != null){
                    clientFound.get().setEmail(client.getEmail());
                }
                if(client.getName() != null){
                    clientFound.get().setName(client.getName());
                }
                if (client.getAge() != null){
                    clientFound.get().setAge(client.getAge());
                }
                if (client.getPassword() != null){
                    clientFound.get().setPassword(client.getPassword());
                }

                return clientRepository.save(clientFound.get());
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient(int id){
        Boolean respuesta = getClient(id).map( client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return respuesta;
    }
}