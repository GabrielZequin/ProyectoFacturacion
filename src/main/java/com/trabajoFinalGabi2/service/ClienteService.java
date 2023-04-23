package com.trabajoFinalGabi2.service;

import com.trabajoFinalGabi2.entity.Cliente;

import java.util.Optional;

public interface ClienteService {

    Optional<Cliente> obtenerClientePorId(Long id);

    Cliente guardarCliente(Cliente cliente);

    Cliente modificarCliente(Cliente cliente);

    String borrarCliente(Long id);

    Cliente obtenerClientePorDni(int dni);

}
