package com.dreps.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "usuarios")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "rol",nullable = true,length = 20)
    private String rol;

    @Column(name = "contrasena",nullable = false)
    private String contrasena;


}
