package com.shirlyreto3.shirly.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


@Entity
@Table(name = "Admin")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")

    private int idAdmin;
    @Column(length = 45)
    private String email;
    @Column(length = 45)
    private String password;
    @Column(length = 3)
    private String age;
    @Column(length = 250)
    private String name;



}
