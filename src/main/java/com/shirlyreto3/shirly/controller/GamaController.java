package com.shirlyreto3.shirly.controller;

import com.shirlyreto3.shirly.Model.Gama;
import com.shirlyreto3.shirly.Service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", methods={RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Gama")
public class GamaController {

    @Autowired
    GamaService gamaService;
    @GetMapping("/all")
    public List<Gama> getAll() {
        return gamaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Gama> getGama(@PathVariable int id) {
        return gamaService.getGama(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Gama car) {
        gamaService.save(car);
    }
}





