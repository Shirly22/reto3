package com.shirlyreto3.shirly.controller;

import com.shirlyreto3.shirly.Model.Admin;
import com.shirlyreto3.shirly.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    @GetMapping("/all")
    public List<Admin> obtener() {return adminService.obtener();}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear (@RequestBody Admin admin){
        adminService.guardar(admin);}
}





