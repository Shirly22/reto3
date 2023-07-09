package com.shirlyreto3.shirly.Service;

import com.shirlyreto3.shirly.Model.Gama;
import com.shirlyreto3.shirly.Repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GamaService {
    @Autowired
    GamaRepository gamaRepository;
    public List<Gama> getAll(){
        return (List<Gama>) gamaRepository.findAll();
    }

    public Optional<Gama> getGama(int id){
        return gamaRepository.getGama(id);
    }

    public Gama save(Gama gama){
        if(gama.getIdGama() == null){
            return gamaRepository.save(gama);
        } else {
            Optional<Gama> gamaFound = getGama(gama.getIdGama());
            if(gamaFound.isPresent()){
                return gamaRepository.save(gama);
            } else {
                return gama;
            }
        }
    }

    public Gama update(Gama gama){
        if(gama.getIdGama() != null){
            Optional<Gama> gamaFound = getGama(gama.getIdGama());
            if (gamaFound.isPresent()){
                if(gama.getDescription() != null){
                    gamaFound.get().setDescription(gama.getDescription());
                }
                if(gama.getName() != null){
                    gamaFound.get().setName(gama.getName());
                }

                return gamaRepository.save(gamaFound.get());
            } else {
                return gama;
            }
        } else {
            return gama;
        }
    }

    public boolean deleteGama(int id){
        Boolean respuesta = getGama(id).map( gama -> {
            gamaRepository.delete(gama);
            return true;
        }).orElse(false);
        return respuesta;
    }
}