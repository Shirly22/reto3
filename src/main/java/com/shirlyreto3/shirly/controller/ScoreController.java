package com.shirlyreto3.shirly.controller;

import com.shirlyreto3.shirly.Model.Score;
import com.shirlyreto3.shirly.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="*", methods={RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;
    @GetMapping("/all")
    public List<Score> getAll() {
        return scoreService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable int id) {
        return scoreService.getScore(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Score car) {
        scoreService.save(car);
    }
}





