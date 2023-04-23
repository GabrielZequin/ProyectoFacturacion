package com.trabajoFinalGabi2.service;

import com.trabajoFinalGabi2.entity.Producto;
import com.trabajoFinalGabi2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    ProductoRepository productoRepository;

    public Producto getProducto(Long id){
        return productoRepository.findById(id).get();
    }
    public Producto modificarProducto(Producto producto){
       Producto productoModificado = productoRepository.findById(producto.getId()).get();
       productoModificado.setNombre(producto.getNombre());
       return productoModificado;
    }
    public Producto guardarProducto(Producto producto){
        return productoRepository.save(producto);
    }
    public String eliminarProducto(Long id){
        Optional<Producto> productoBorrado = productoRepository.findById(id);
       productoRepository.deleteById(id);
       return "Borraste el producto: " + productoBorrado;
    }
    public String restarStock(Long id, int cantidad){
        Producto producto = productoRepository.findById(id).get();

        if (producto.getCantidadEnStock() >= cantidad){
            int stokActual = producto.getCantidadEnStock() - cantidad;
            producto.setCantidadEnStock(stokActual);
            productoRepository.save(producto);
        }else {
          return "No tenemos esa cantidad disponible. La cantidad en stok es: "+producto.getCantidadEnStock();
        }
        return "La compra fue exitosa";
    }
}
