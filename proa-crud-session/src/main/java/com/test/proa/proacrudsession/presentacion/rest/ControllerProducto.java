package com.test.proa.proacrudsession.presentacion.rest;


import com.test.proa.proacrudsession.anotacion.LogObjectAfter;
import com.test.proa.proacrudsession.anotacion.LogObjectBefore;
import com.test.proa.proacrudsession.capa.datos.model.Producto;
import com.test.proa.proacrudsession.servicio.negocio.ProductoService;
import com.test.proa.proacrudsession.servicio.negocio.models.ProductoR;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/productos")
public class ControllerProducto {

    @Autowired
    ProductoService productoService;

    private static String  ID_CLIENT_SESSION = "78965088";

    @LogObjectBefore
    @LogObjectAfter
    @PostMapping
    public Producto altaProducto(@RequestBody ProductoR pro) {
          return productoService.agregaProducto(pro);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PutMapping
    public Producto actualizaProducto(@RequestBody ProductoR pro){
        return productoService.actualizaProducto(pro);
    }


    @GetMapping("/id/{id}/producto")
    public Object obtenerProductoPorId(HttpServletRequest request, @PathVariable String id) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ID_CLIENT_SESSION")) {
                    System.out.println("cookie.getValue() = " + cookie.getValue());
                    if (cookie.getValue().equals(ID_CLIENT_SESSION)) {
                        return productoService.obtenerProducto(id);
                    } else {
                        log.info("Session invalida");
                        return "Invalid session";
                                                   }
                }
            }
        }
        return productoService.obtenerProducto(id);
    }

    @GetMapping("/listado")
    public List<Producto> obtenerProductos(){
            return productoService.listaProductos();
        }

}
