package com.asincrono.asincrona.servicio;

import com.asincrono.asincrona.modelo.Producto;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Servicio el cual contiene métodos configurados de manera ASINCRONA.
 */
@Service
public class ServicioProductoAsync {

    /**
     * @Async: Se indica que este método trabajará de manera asincrona
     * y se hace referencia al pool de hilos con el nombre "asyncExecutor"
     * el cual fue configurado en el Bean de la clase "AsyncConfiguracion"
     */
    @Async("asyncExecutor")
    public CompletableFuture<List<Producto>> obtenerProductos1() throws InterruptedException {
        //Este sleep no SOLO PARA SIMULAR tiempo de procesamiento.
        Thread.sleep(1000);

        List<Producto> lista = Arrays.asList(new Producto(1, "Producto1"),
                new Producto(2, "Producto2"));
        return CompletableFuture.completedFuture(lista);
    }

    @Async("asyncExecutor")
    public CompletableFuture<List<Producto>> obtenerProductos2() throws InterruptedException {
        //Este sleep no SOLO PARA SIMULAR tiempo de procesamiento.
        Thread.sleep(2000);

        List<Producto> lista = Arrays.asList(new Producto(3, "Producto3"),
                new Producto(4, "Producto4"));
        return CompletableFuture.completedFuture(lista);
    }

    @Async("asyncExecutor")
    public CompletableFuture<List<Producto>> obtenerProductos3() throws InterruptedException {
        //Este sleep no SOLO PARA SIMULAR tiempo de procesamiento.
        Thread.sleep(3000);

        List<Producto> lista = Arrays.asList(new Producto(5, "Producto5"),
                new Producto(6, "Producto6"));
        return CompletableFuture.completedFuture(lista);
    }

    @Async("asyncExecutor")
    public CompletableFuture<List<Producto>> obtenerProductos4() throws InterruptedException {
        //Este sleep no SOLO PARA SIMULAR tiempo de procesamiento.
        Thread.sleep(1000);

        List<Producto> lista = Arrays.asList(new Producto(7, "Producto7"),
                new Producto(7, "Producto7"));
        return CompletableFuture.completedFuture(lista);
    }
}
