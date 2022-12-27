package com.asincrono.asincrona.controlador;

import com.asincrono.asincrona.modelo.Producto;
import com.asincrono.asincrona.servicio.ServicioProductoAsync;
import com.asincrono.asincrona.servicio.ServicioProductoSincrono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/productos")
public class ControladorProducto {

    //Servicio con métodos configurados de manera asincrona
    private ServicioProductoAsync servicioProductoAsync;

    //Servicio con métodos tradicionales (sincrono)
    private ServicioProductoSincrono servicioProductoSincrono;


    public ControladorProducto(ServicioProductoAsync servicioProductoAsync,
                               ServicioProductoSincrono servicioProductoSincrono) {
        this.servicioProductoAsync = servicioProductoAsync;
        this.servicioProductoSincrono = servicioProductoSincrono;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ControladorProducto.class);

    @GetMapping("/async")
    public List<Producto> obtenerProductosAsync(){
        try {
            long inicio = System.currentTimeMillis();

            CompletableFuture<List<Producto>> listaProductos1 = servicioProductoAsync
                    .obtenerProductos1();

            CompletableFuture<List<Producto>> listaProductos2 = servicioProductoAsync
                    .obtenerProductos2();

            CompletableFuture<List<Producto>> listaProductos3 = servicioProductoAsync
                    .obtenerProductos3();

            CompletableFuture<List<Producto>> listaProductos4 = servicioProductoAsync
                    .obtenerProductos4();

            /**
             * El método estático CompletableFuture.allOf() permite ESPERAR
             * a que se completen todos los futuros proporcionados.
             *
             * join(): Devuelve el valor del resultado cuando se COMPLETA.
             */
            CompletableFuture.allOf(listaProductos1, listaProductos2,
                    listaProductos3, listaProductos4).join();

            /**
             * Se genera una lista final con el resultado de todos los llamados asincronos.
             *
             * .get(): ESPERA si es necesario a que se complete este futuro y luego devuelve su resultado.
             */
            List<Producto> listaFinal = Stream.of(listaProductos1.get(), listaProductos2.get(),
                    listaProductos3.get(), listaProductos4.get())
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());

            long fin = System.currentTimeMillis();
            LOGGER.info("xxxxxxxxx Tiempo total ejecución en milisegundos: {}", fin - inicio);

            return listaFinal;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/sincrono")
    public List<Producto> obtenerProductosSincrono(){
        try {
            long inicio = System.currentTimeMillis();

            List<Producto> listaProductos1 = servicioProductoSincrono
                    .obtenerProductos1();

            List<Producto> listaProductos2 = servicioProductoSincrono
                    .obtenerProductos2();

            List<Producto> listaProductos3 = servicioProductoSincrono
                    .obtenerProductos3();

            List<Producto> listaProductos4 = servicioProductoSincrono
                    .obtenerProductos4();


            List<Producto> listaFinal = Stream.of(listaProductos1, listaProductos2,
                            listaProductos3, listaProductos4)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());

            long fin = System.currentTimeMillis();
            LOGGER.info("xxxxxxxxx Tiempo total ejecución en milisegundos: {}", fin - inicio);

            return listaFinal;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
