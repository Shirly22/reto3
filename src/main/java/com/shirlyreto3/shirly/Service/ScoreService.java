package com.shirlyreto3.shirly.Service;

import com.shirlyreto3.shirly.Model.Score;
import com.shirlyreto3.shirly.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;
    public List<Score> getAll(){
        return (List<Score>) scoreRepository.findAll();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score score){
        if(score.getIdScore() == null){
            return scoreRepository.save(score);
        } else {
            Optional<Score> scoreFound = getScore(score.getIdScore());
            if(scoreFound.isPresent()){
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }

    public Score update(Score score){
        if(score.getIdScore() != null){
            Optional<Score> scoreFound = getScore(score.getIdScore());
            if (scoreFound.isPresent()){
                if(score.getMessageText() != null){
                    scoreFound.get().setMessageText(score.getMessageText());
                }

                if(score.getStars() != null){
                    scoreFound.get().setStars(score.getStars());
                }

                return scoreRepository.save(scoreFound.get());
            } else {
                return score;
            }
        } else {
            return score;
        }
    }

    public boolean deleteScore(int id){
        Boolean respuesta = getScore(id).map( gama -> {
            scoreRepository.delete(gama);
            return true;
        }).orElse(false);
        return respuesta;
    }
}