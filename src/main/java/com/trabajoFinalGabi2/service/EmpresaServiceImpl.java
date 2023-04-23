package com.trabajoFinalGabi2.service;

import com.trabajoFinalGabi2.entity.Empresa;
import com.trabajoFinalGabi2.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService{

    @Autowired
    EmpresaRepository empresaRepository;

    public Empresa obtenerEmpresaPorId(Long id){
        return empresaRepository.findById(id).get();
    }
}
