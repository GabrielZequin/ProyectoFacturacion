package com.trabajoFinalGabi2.service;

import com.trabajoFinalGabi2.dto.ClienteDto;
import com.trabajoFinalGabi2.dto.FacturasPorClienteDto;
import com.trabajoFinalGabi2.dto.IngresoFacturaDto;
import com.trabajoFinalGabi2.dto.ProductoDto;
import com.trabajoFinalGabi2.entity.Cliente;
import com.trabajoFinalGabi2.entity.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaService {

    String generarFactura(IngresoFacturaDto ingresoFacturaDto);
    FacturasPorClienteDto facturasPorCliente(Cliente cliente);
    String borrarFacturaPorID(Long id);
    Optional<Factura> obtenerFacturaPorId(Long id);

}
