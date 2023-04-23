package com.trabajoFinalGabi2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturasPorClienteDto {

    private ClienteDto clienteDto;

    private String facturasIds;
}
