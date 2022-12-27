package com.asincrono.asincrona.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Clase de configuración para el manedo de funcionalidades asincronas.
 *
 * @Configuration: Indica clase de configuración.
 * @EnableAsync: Habilita el manejo de funcionalides asincronas.
 */
@Configuration
@EnableAsync
public class AsyncConfiguracion {

    /**
     * Se crea un "Executor" para configurar el pool de hilos.
     * Se le asigna un nombre al bean para las ejecuciones asincronas.
     * En este caso "asyncExecutor" el cual será referenciado en las otras clases
     * que implementen llamados asincronos.
     *
     * También se configuran los hilos y el prefijo del
     * nombre de los hilos para las ejeciones asincronas.
     */
    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("Async-thread-");
        executor.initialize();
        return executor;
    }

}
