package com.trabajoFinalGabi2.service;
import com.trabajoFinalGabi2.dto.ClienteDto;
import com.trabajoFinalGabi2.dto.IngresoFacturaDto;
import com.trabajoFinalGabi2.dto.ProductoDto;
import com.trabajoFinalGabi2.repository.FacturaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FacturaServiceImplTest {

    @Mock
    FacturaRepository facturaRepository;
    @Mock
    ClienteService clienteService;
    @Mock
    ProductoService productoService;
    @Mock
    EmpresaService empresaService;
    @InjectMocks
    private FacturaServiceImpl facturaService;

    @Test
    void generarFactura() {

        ClienteDto clienteDto = new ClienteDto("Juan", "Perez", "Calle 123", 34567889);
        ProductoDto productoDto = new ProductoDto(1L, 2);
        List<ProductoDto> productoDtoList = new ArrayList<>();
        productoDtoList.add(productoDto);
        IngresoFacturaDto ingresoFacturaDto = new IngresoFacturaDto(clienteDto, productoDtoList);

        facturaService.generarFactura(ingresoFacturaDto);


    }
}