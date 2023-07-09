package com.shirlyreto3.shirly.Repository;

import com.shirlyreto3.shirly.Model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shirlyreto3.shirly.Repository.CRUD.ScoreCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> findAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }

    public Score save(Score score){
        return scoreCrudRepository.save(score);
    }

    public void delete(Score score){
        scoreCrudRepository.delete(score);
    }
}