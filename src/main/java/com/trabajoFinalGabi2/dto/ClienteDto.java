package com.trabajoFinalGabi2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private String nombre;

    private String apellido;

    private String direccion;

    private int dni;
}
