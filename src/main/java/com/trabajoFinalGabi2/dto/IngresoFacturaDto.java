package com.trabajoFinalGabi2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngresoFacturaDto {

    private ClienteDto clienteDto;

    private List<ProductoDto> productoDtos;

}
