package com.trabajoFinalGabi2.service;

import com.trabajoFinalGabi2.Exception.FacturaException;
import com.trabajoFinalGabi2.dto.FacturasPorClienteDto;
import com.trabajoFinalGabi2.dto.IngresoFacturaDto;
import com.trabajoFinalGabi2.dto.ClienteDto;
import com.trabajoFinalGabi2.dto.ProductoDto;
import com.trabajoFinalGabi2.entity.*;
import com.trabajoFinalGabi2.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    FacturaRepository facturaRepository;
    @Autowired
    ClienteService clienteService;
    @Autowired
    ProductoService productoService;
    @Autowired
    EmpresaService empresaService;


    public Optional<Factura> obtenerFacturaPorId(Long id){
        Optional<Factura> facturaEncontrada = facturaRepository.findById(id);

        if (!facturaEncontrada.isPresent()){
            throw new FacturaException("La factura con el id: "+ id + "no existe");
        }
        return facturaEncontrada;
    }
    public String borrarFacturaPorID(Long id){
        facturaRepository.deleteById(id);
        return "Borraste la factura con id: " + id;
    }
    public String generarFactura(IngresoFacturaDto ingresoFacturaDto) {
        ClienteDto clienteDto = ingresoFacturaDto.getClienteDto();
        Cliente cliente = clienteService.obtenerClientePorDni(clienteDto.getDni());

        if (cliente == null) {
            Cliente clienteNuevo = new Cliente(clienteDto.getNombre(), clienteDto.getApellido(),
                    clienteDto.getDireccion(), clienteDto.getDni());
            clienteService.guardarCliente(clienteNuevo);
            cliente = clienteNuevo;
        }

        List<Optional<Producto>> productosSinStock = new ArrayList<>();
        for (ProductoDto productoDto : ingresoFacturaDto.getProductoDtos()) {
            Optional<Producto> producto = Optional.ofNullable(productoService.getProducto(productoDto.getId()));
            if (productoDto.getCantidad() > producto.get().getCantidadEnStock()) {
                productosSinStock.add(producto);
            }
        }
        if (!productosSinStock.isEmpty()) {
            return "No hay stock para los productos: " + productosSinStock.stream().map(producto -> producto.get().getNombre())
                    .collect(Collectors.joining("-", "{", "}"));
        }


        Factura factura = new Factura(000 - 00001, "12/06/23", "A", cliente, empresaService.obtenerEmpresaPorId(1L));

        List<DetalleFactura> detalleFacturaList = new ArrayList<>();
        for (ProductoDto productoDto : ingresoFacturaDto.getProductoDtos()) {
            Producto producto = productoService.getProducto(productoDto.getId());
            int cantidad = productoDto.getCantidad();
            double totalParcial = cantidad * producto.getPrecio();
            DetalleFactura detalleFactura = new DetalleFactura(producto, cantidad, totalParcial, factura);
            detalleFacturaList.add(detalleFactura);

            double total = producto.getPrecio() * productoDto.getCantidad();

            factura.setTotalFactura(total);
            factura.setDetalleFactura(detalleFacturaList);
        }
        facturaRepository.save(factura);
        return "La factura se generó con exito";

        }
        public FacturasPorClienteDto facturasPorCliente(Cliente cliente){
        List<Factura> facturas = new ArrayList<>();
        facturas.add(facturaRepository.findByClienteId(cliente.getId()));
        ClienteDto clienteDto = new ClienteDto(cliente.getNombre(), cliente.getApellido(), cliente.getDireccion(),
        cliente.getDni());
        String facturasIds = "Facturas ids: " + facturas.stream().map(factura -> String.valueOf(factura.getId()))
                .collect(Collectors.joining("-", "{", "}"));
        FacturasPorClienteDto facturasPorClienteDto = new FacturasPorClienteDto(clienteDto, facturasIds);
        return facturasPorClienteDto;
        }

    }
