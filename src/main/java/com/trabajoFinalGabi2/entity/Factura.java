package com.trabajoFinalGabi2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity(name = "factura")
@Table(name = "factura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero")
    private int numero;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "tipo_de_factura")
    private String tipoDeFactura;

    @JoinColumn(name = "cliente_id")
    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "factura", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<DetalleFactura> detalleFactura;

    @JoinColumn(name = "empresa_id")
    @ManyToOne
    private Empresa empresa;

    @Column(name = "total_factura")
    private double totalFactura;


    public Factura( int numero, String fecha, String tipoDeFactura, Cliente cliente, Empresa empresa) {
        this.cliente = cliente;
        this.numero = numero;
        this.empresa = empresa;
        this.fecha = fecha;
        this.tipoDeFactura = tipoDeFactura;

    }
}
