package com.trabajoFinalGabi2.controller;

import com.trabajoFinalGabi2.entity.Cliente;
import com.trabajoFinalGabi2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/getCliente/{id}")
    public Optional<Cliente> getCliente(@PathVariable(value = "id")Long id){
        return clienteService.obtenerClientePorId(id);

    }
    @GetMapping("/getClienteByDni/{dni}")
    public Optional<Cliente> getClienteByDni(@PathVariable(value = "dni")int dni){
        return Optional.ofNullable(clienteService.obtenerClientePorDni(dni));

    }
    @PostMapping("/guardarCliente")
    public Cliente guardarCliente(Cliente cliente){
        return clienteService.guardarCliente(cliente);
    }
    @PutMapping("/modificarCliente")
    public Cliente modificarCliente(Cliente cliente){
        return clienteService.modificarCliente(cliente);
    }
    @DeleteMapping("/borrarCliente/{id}")
    public String borrarCliente(@PathVariable(value = "id")Long id){
        return clienteService.borrarCliente(id);
    }
}
