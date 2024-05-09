package com.test.proa.proacrudsession.capa.datos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Producto {

    @Id
    private String idProducto;
    @Column(name = "descripcion")
    private String desc;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "marca")
    private String marca;



}
