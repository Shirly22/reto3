package com.shirlyreto3.shirly.Service;

import com.shirlyreto3.shirly.Model.Admin;
import com.shirlyreto3.shirly.Repository.CRUD.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AdminService {
    @Autowired
    AdminCrudRepository adminRepository;

    public List<Admin> obtener() {
        return (List<Admin>) adminRepository.findAll();
    }

    public void guardar(Admin admin) {
        adminRepository.save(admin);}
    }




