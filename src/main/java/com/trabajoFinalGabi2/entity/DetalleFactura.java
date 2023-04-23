package com.trabajoFinalGabi2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "detalle_de_factura")
@Table(name = "detalle_de_factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "producto_id")
    @ManyToOne
    private Producto producto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "total_parcial")
    private double toralParcial;

    @JoinColumn(name = "factura_id")
    @ManyToOne
    private Factura factura;


    public DetalleFactura(Producto producto, int cantidadEnStock, double toralParcial) {

    }

    public DetalleFactura(Producto producto, int cantidad, double totalParcial, Factura factura) {
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
        this.toralParcial = totalParcial;

    }

    public void setProductos(String nombre, String descripcion,  double precio) {

    }
}
