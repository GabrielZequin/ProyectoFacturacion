package com.trabajoFinalGabi2.controller;

import com.trabajoFinalGabi2.entity.Producto;
import com.trabajoFinalGabi2.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/getProducto/{id}")
    public Producto getProducto(@PathVariable(value = "id")Long id){
        return productoService.getProducto(id);
    }
    @PutMapping("/restarStock/{id}/{cant}")
    public String restarStock(@PathVariable(value = "id")Long id, @PathVariable(value = "cant")int cant){
            return productoService.restarStock(id, cant);
    }
}
