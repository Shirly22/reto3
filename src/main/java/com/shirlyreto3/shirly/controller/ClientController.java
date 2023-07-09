package com.shirlyreto3.shirly.controller;

import com.shirlyreto3.shirly.Model.Client;
import com.shirlyreto3.shirly.Model.Client;
import com.shirlyreto3.shirly.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", methods={RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    ClientService clientService;
    @GetMapping("/all")
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable int id) {
        return clientService.getClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Client car) {
        clientService.save(car);
    }
}