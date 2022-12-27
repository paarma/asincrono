package com.asincrono.asincrona.servicio;

import com.asincrono.asincrona.modelo.Producto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Servicio el cual contiene métodos configurados de manera tradicional sincrono.
 */
@Service
public class ServicioProductoSincrono {

    public List<Producto> obtenerProductos1() throws InterruptedException {
        //Este sleep no SOLO PARA SIMULAR tiempo de procesamiento.
        Thread.sleep(1000);

        List<Producto> lista = Arrays.asList(new Producto(1, "Producto1"),
                new Producto(2, "Producto2"));
        return lista;
    }

    public List<Producto> obtenerProductos2() throws InterruptedException {
        //Este sleep no SOLO PARA SIMULAR tiempo de procesamiento.
        Thread.sleep(2000);

        List<Producto> lista = Arrays.asList(new Producto(3, "Producto3"),
                new Producto(4, "Producto4"));
        return lista;
    }

    public List<Producto> obtenerProductos3() throws InterruptedException {
        //Este sleep no SOLO PARA SIMULAR tiempo de procesamiento.
        Thread.sleep(3000);

        List<Producto> lista = Arrays.asList(new Producto(5, "Producto5"),
                new Producto(6, "Producto6"));
        return lista;
    }

    public List<Producto> obtenerProductos4() throws InterruptedException {
        //Este sleep no SOLO PARA SIMULAR tiempo de procesamiento.
        Thread.sleep(1000);

        List<Producto> lista = Arrays.asList(new Producto(7, "Producto7"),
                new Producto(7, "Producto7"));
        return lista;
    }
}
