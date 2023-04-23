package com.trabajoFinalGabi2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column(name= "nombre")
    private String nombre;

    @Column(name= "apellido")
    private String apellido;

    @Column(name= "direccion")
    private String direccion;

    @Column(name= "dni")
    private int dni;


    public Cliente(String nombre, String apellido, String direccion, int dni) {

    }
}
