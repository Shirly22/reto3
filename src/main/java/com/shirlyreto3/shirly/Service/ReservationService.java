package com.shirlyreto3.shirly.Service;

import com.shirlyreto3.shirly.Model.Reservation;
import com.shirlyreto3.shirly.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservationFound = getReservation(reservation.getIdReservation());
            if(reservationFound.isPresent()){
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation() != null){
            Optional<Reservation> reservationFound = getReservation(reservation.getIdReservation());
            if (reservationFound.isPresent()){
                if(reservation.getStartDate() != null){
                    reservationFound.get().setStartDate(reservation.getStartDate());
                }

                if(reservation.getDevolutionDate() != null){
                    reservationFound.get().setDevolutionDate(reservation.getDevolutionDate());
                }

                if(reservation.getStatus() != null){
                    reservationFound.get().setStatus(reservation.getStatus());
                }

                return reservationRepository.save(reservationFound.get());
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean deleteReservation(int id){
        Boolean respuesta = getReservation(id).map( gama -> {
            reservationRepository.delete(gama);
            return true;
        }).orElse(false);
        return respuesta;
    }
}