package com.shirlyreto3.shirly.controller;

import com.shirlyreto3.shirly.Model.Message;
import com.shirlyreto3.shirly.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="*", methods={RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    MessageService messageService;
    @GetMapping("/all")
    public List<Message> getAll() {
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable int id) {
        return messageService.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Message car) {
        messageService.save(car);
    }
}





