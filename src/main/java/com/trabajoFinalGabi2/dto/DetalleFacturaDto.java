package com.trabajoFinalGabi2.dto;

import com.trabajoFinalGabi2.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleFacturaDto {

    private Producto producto;

    private int cantidad;

    private double totalParcial;
}
