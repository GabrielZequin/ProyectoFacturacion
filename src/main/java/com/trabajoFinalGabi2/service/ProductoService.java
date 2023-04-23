package com.trabajoFinalGabi2.service;

import com.trabajoFinalGabi2.entity.Producto;

public interface ProductoService {

    Producto getProducto(Long id);
    String restarStock(Long id, int cantidad);
    String eliminarProducto(Long id);
    Producto guardarProducto(Producto producto);
    Producto modificarProducto(Producto producto);
}
