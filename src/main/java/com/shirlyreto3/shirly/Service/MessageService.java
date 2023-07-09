package com.shirlyreto3.shirly.Service;

import com.shirlyreto3.shirly.Model.Message;
import com.shirlyreto3.shirly.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MessageService {
    @Autowired
    MessageRepository messageRepository;
    public List<Message> getAll(){
        return (List<Message>) messageRepository.findAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message message){
        if(message.getIdMessage() == null){
            return messageRepository.save(message);
        } else {
            Optional<Message> gamaFound = getMessage(message.getIdMessage());
            if(gamaFound.isPresent()){
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }

    public Message update(Message message){
        if(message.getIdMessage() != null){
            Optional<Message> gamaFound = getMessage(message.getIdMessage());
            if (gamaFound.isPresent()){
                if(message.getMessageText() != null){
                    gamaFound.get().setMessageText(message.getMessageText());
                }

                return messageRepository.save(gamaFound.get());
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean deleteMessage(int id){
        Boolean respuesta = getMessage(id).map( gama -> {
            messageRepository.delete(gama);
            return true;
        }).orElse(false);
        return respuesta;
    }
}