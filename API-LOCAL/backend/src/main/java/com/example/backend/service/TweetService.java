package com.example.backend.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.backend.model.Tweet;
import com.example.backend.repository.TweetRepository;

@Service
public class TweetService {
    private final TweetRepository tweetRepository;

    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    // Para cada servicio, se ejecuta una hebra con @Async("asyncExecutor")

    //Servicio que muestre todos los tweets
    @Async("asyncExecutor")
    public CompletableFuture<List<Tweet>> getAll(){
        List<Tweet> list = tweetRepository.findAll();
        return CompletableFuture.completedFuture(list);
    }

    //Servicio que muestre la cantidad total de tweets
    @Async("asyncExecutor")
	public CompletableFuture<Long> count() {
        long count = tweetRepository.count();
		return CompletableFuture.completedFuture(count);
	}

    //Servicio que entrege la suma de los favoritos
    @Async("asyncExecutor")
	public CompletableFuture<Double> sumFav() {
        double sum = tweetRepository.sumFav();
		return CompletableFuture.completedFuture(sum);
	}

    //Servicio que entrege la desviacion estándar de los favoritos
    @Async("asyncExecutor")
	public CompletableFuture<Double> stdFav() {
        double std = tweetRepository.stdFav();
		return CompletableFuture.completedFuture(std);
	}

    //Servicio que entrege la suma de los reetweets
    @Async("asyncExecutor")
	public CompletableFuture<Double> sumRet() {
        double sum = tweetRepository.sumRet();
		return CompletableFuture.completedFuture(sum);
	}

    //Servicio que entrege la desviacion estándar de los reetweets
    @Async("asyncExecutor")
	public CompletableFuture<Double> stdRet() {
        double std = tweetRepository.stdRet();
		return CompletableFuture.completedFuture(std);
	}
    
 
    
}
