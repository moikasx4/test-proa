package com.test.proa.proacrudsession.servicio.negocio;

import com.test.proa.proacrudsession.capa.datos.model.Producto;
import com.test.proa.proacrudsession.servicio.negocio.models.ProductoR;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductoService {

    Producto agregaProducto(ProductoR pro);
    Producto actualizaProducto(ProductoR pro);
    Optional<Producto> obtenerProducto(String id);
    List<Producto> listaProductos();

}
