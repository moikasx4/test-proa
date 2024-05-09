package com.test.proa.proacrudsession.aspect;

import com.test.proa.proacrudsession.capa.datos.model.Producto;
import com.test.proa.proacrudsession.servicio.negocio.models.ProductoR;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Before("@annotation(com.test.proa.proacrudsession.anotacion.LogObjectBefore)")
    public void logProductosBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Producto) {
                Producto pro = (Producto) arg;
                log.info("******* before :: {}", pro);
            }
            else if (arg instanceof ProductoR) {
                ProductoR proR = (ProductoR) arg;
                log.info("******* before :: {}", proR);
            }
        }
    }
    @AfterReturning(value = "@annotation(com.test.proa.proacrudsession.anotacion.LogObjectAfter)", returning = "result")
    public void logProductosAfter(JoinPoint joinPoint,  Object result) {
        Object[] args = joinPoint.getArgs();
        if (Objects.nonNull(result)) {
            if (result instanceof Producto) {
                Producto responseEntity = (Producto) result;
                log.info("******* Returning Entity :: {} ("
                        + " id: " + responseEntity.getIdProducto()
                        + ", desc: " +  responseEntity.getDesc()
                        +  ", nombre: "  + responseEntity.getNombre()
                        +  ", marca: " + responseEntity.getMarca() + ")");
            }
                else
                    log.error("Something went wrong while logging...!");
            }
        }
    }
