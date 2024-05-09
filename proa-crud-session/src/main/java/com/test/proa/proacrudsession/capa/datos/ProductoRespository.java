package com.test.proa.proacrudsession.capa.datos;

import com.test.proa.proacrudsession.capa.datos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRespository extends JpaRepository<Producto, String> {
}
