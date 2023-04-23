package com.trabajoFinalGabi2.repository;

import com.trabajoFinalGabi2.entity.Cliente;
import com.trabajoFinalGabi2.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

       Factura findByClienteId(Long id);
}
