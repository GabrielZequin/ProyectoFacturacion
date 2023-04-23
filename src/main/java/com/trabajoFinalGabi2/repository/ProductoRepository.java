package com.trabajoFinalGabi2.repository;

import com.trabajoFinalGabi2.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Producto findByNombre (String nombre);

}
