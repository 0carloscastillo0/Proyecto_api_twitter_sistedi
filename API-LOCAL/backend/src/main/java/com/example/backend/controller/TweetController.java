package com.example.backend.controller;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.example.backend.model.Tweet;
import com.example.backend.service.TweetService;

@RestController
@RequestMapping("tweets")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class TweetController {
    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    //--------------------------------------------------------------------------------------------
    //                              CONSULTAS IMPLEMENTADAS
    //--------------------------------------------------------------------------------------------
    // Mostrar la informacion de todos los tweets extraidos de la base de datos
    @GetMapping(value="/all")
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    public List<Tweet> getAll() throws InterruptedException, ExecutionException{
        // Se llama al servicio
        CompletableFuture<List<Tweet>> t = tweetService.getAll();
        
        //Se espera a que termine el servicio
        CompletableFuture.allOf(t).join();

        //Se extrae el resultado del proceso de la ejecucion
        List<Tweet> list = Stream.of(t.get())
            .flatMap(Collection::stream)
            .collect(Collectors.toList());


        return list;
    }
    //--------------------------------------------------------------------------------------------
    // Mostrar la cantidad de tweets cargados
    @GetMapping(value="/countTweets")
    @CrossOrigin(origins = "*",allowedHeaders = "*")

    public long count() throws InterruptedException, ExecutionException{
        // Se llama al servicio
        CompletableFuture<Long> t = tweetService.count();

        // Se espera a que termine
        CompletableFuture.allOf(t).join();

        //Se extrae el resultado del proceso
        long count = t.get();

        return count;
    }

    //------------------------------------------------------------------------------------------
    // Mostrar la media de la cantidad de favoritos
    @GetMapping(value="/meanFav")
    @CrossOrigin(origins = "*",allowedHeaders = "*")

    public double meanFav() throws InterruptedException, ExecutionException{
        // Se llama a los servicios
        CompletableFuture<Long> t1 = tweetService.count();
        CompletableFuture<Double> t2 = tweetService.sumFav();

        // Se espera a que terminen los servicios
        CompletableFuture.allOf(t1, t2).join();

        // Se extraen los servicios y se realiza el calculo
        double mean = t2.get()/t1.get();
        return mean;
    }

    //------------------------------------------------------------------------------------------
    // Mostrar la varianza de la cantidad de favoritos
    @GetMapping(value="/varFav")
    @CrossOrigin(origins = "*",allowedHeaders = "*")

    public double varFav() throws InterruptedException, ExecutionException{
        // Se llama a los servicios
        CompletableFuture<Double> t1 = tweetService.stdFav();
        CompletableFuture<Double> t2 = tweetService.stdFav();

        // Se espera a que terminen los servicios
        CompletableFuture.allOf(t1, t2).join();

        // Se extraen los servicios y se realiza el calculo
        double var = t2.get() * t1.get();
        return var;
    }

    //------------------------------------------------------------------------------------------
    // Mostrar la media de la cantidad de retweets
    @GetMapping(value="/meanRet")
    @CrossOrigin(origins = "*",allowedHeaders = "*")

    public double meanRet() throws InterruptedException, ExecutionException{
        // Se llama a los servicios
        CompletableFuture<Long> t1 = tweetService.count();
        CompletableFuture<Double> t2 = tweetService.sumRet();

        // Se espera a que terminen los servicios
        CompletableFuture.allOf(t1, t2).join();

        // Se extraen los servicios y se realiza el calculo
        double mean = t2.get()/t1.get();
        return mean;
    }

    //------------------------------------------------------------------------------------------
    // Mostrar la varianza de la cantidad de retweets
    @GetMapping(value="/varRet")
    @CrossOrigin(origins = "*",allowedHeaders = "*")

    public double varRet() throws InterruptedException, ExecutionException{
        // Se llama a los servicios
        CompletableFuture<Double> t1 = tweetService.stdRet();
        CompletableFuture<Double> t2 = tweetService.stdRet();

        // Se espera a que terminen los servicios
        CompletableFuture.allOf(t1, t2).join();

        // Se extraen los servicios y se realiza el calculo
        double var = t2.get() * t1.get();
        return var;
    }
}
