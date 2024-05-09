package com.test.proa.proacrudsession.servicio.negocio.impl;

import com.test.proa.proacrudsession.capa.datos.ProductoRespository;
import com.test.proa.proacrudsession.capa.datos.model.Producto;
import com.test.proa.proacrudsession.servicio.negocio.ProductoService;
import com.test.proa.proacrudsession.servicio.negocio.models.ProductoR;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Service
public class ProductoServicesImpl implements ProductoService {


    @Autowired
    ProductoRespository productoRespository;


    @Override
    public Producto agregaProducto(ProductoR proR) {
           Producto producto = new Producto();
           producto.setIdProducto(String.valueOf(UUID.randomUUID()));
           producto.setDesc(proR.getDesc());
           producto.setNombre(proR.getNombre());
           producto.setMarca(proR.getMarca());
        return productoRespository.save(producto);
    }

    @Override
    public Producto actualizaProducto(ProductoR pro) {
        Producto producto = new Producto();
        productoRespository.findById(pro.getIdProducto()).orElseThrow();
        producto.setIdProducto(pro.getIdProducto());
        producto.setDesc(pro.getDesc());
        producto.setNombre(pro.getNombre());
        producto.setMarca(pro.getMarca());
        return productoRespository.save(producto);
    }

    @Override
    public Optional<Producto> obtenerProducto(String id) {
        return productoRespository.findById(id);
    }

    @Override
       public List<Producto> listaProductos() {
        return productoRespository.findAll();
    }
}
