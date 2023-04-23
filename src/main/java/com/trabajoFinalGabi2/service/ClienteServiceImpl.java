package com.trabajoFinalGabi2.service;

import com.trabajoFinalGabi2.Exception.ClienteException;
import com.trabajoFinalGabi2.entity.Cliente;
import com.trabajoFinalGabi2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;


    public Optional<Cliente> obtenerClientePorId(Long id){
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (!optionalCliente.isPresent()){
            throw new ClienteException("El ID ingresado no existe");
        }
        return optionalCliente;
    }

    public Cliente guardarCliente(Cliente cliente){
       return clienteRepository.save(cliente);
    }

    public Cliente modificarCliente(Cliente cliente){
       Cliente clienteModificado = clienteRepository.findById(cliente.getId()).get();
       clienteModificado.setNombre(cliente.getNombre());
       return clienteRepository.save(clienteModificado);
    }
    public String borrarCliente(Long id){
        Cliente clienteBorrado = clienteRepository.findById(id).get();
        clienteRepository.deleteById(id);
        return "Borraste a: " + clienteBorrado;
    }
    public Cliente obtenerClientePorDni(int dni){
        return clienteRepository.findByDni(dni);
    }
}
