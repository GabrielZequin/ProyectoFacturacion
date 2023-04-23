package com.trabajoFinalGabi2.controller;

import com.trabajoFinalGabi2.dto.FacturasPorClienteDto;
import com.trabajoFinalGabi2.dto.IngresoFacturaDto;
import com.trabajoFinalGabi2.entity.Cliente;
import com.trabajoFinalGabi2.entity.Factura;
import com.trabajoFinalGabi2.service.ClienteService;
import com.trabajoFinalGabi2.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    @Autowired
    ClienteService clienteService;

    @PostMapping("/generarFactura")
    public ResponseEntity <String> generarFactura(@RequestBody IngresoFacturaDto ingresoFacturaDto){
        return ResponseEntity.ok().body(facturaService.generarFactura(ingresoFacturaDto));
    }
    @GetMapping("/getFacturaPorCliente/{id}")
    public ResponseEntity<FacturasPorClienteDto> getFactura(@PathVariable(value = "id")Long id){
        Cliente cliente = clienteService.obtenerClientePorId(id).get();
        FacturasPorClienteDto facturasPorClienteDto = facturaService.facturasPorCliente(cliente);
        return ResponseEntity.ok().body(facturasPorClienteDto);
    }
    @DeleteMapping("/borrarFacturaPorId/{id}")
    public String borrarFactura(@PathVariable(value = "id")Long id){
        return facturaService.borrarFacturaPorID(id);
    }
    @GetMapping("/obtenerFacturaPorId/{id}")
    public Optional<Factura> obtenerFacturaPorId(@PathVariable(value = "id")Long id){
        return facturaService.obtenerFacturaPorId(id);
    }

}
