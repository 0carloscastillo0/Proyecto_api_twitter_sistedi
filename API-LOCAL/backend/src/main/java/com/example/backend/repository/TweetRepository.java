package com.example.backend.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Tweet;

@Repository
public interface TweetRepository extends MongoRepository<Tweet, ObjectId>{
    // Contar
	@Aggregation(pipeline = {
		"{$group: { _id: '', total: {$sum: 1}}}"
	})
	public long count();
    
	//-------------------------------------------------------------------
	// PARA LOS FAVORITOS:

    // Suma 
    @Aggregation(pipeline = {
		"{$group: { _id: '', total: {$sum: $favoritos}}}"
	})
	public double sumFav();


	//Desviacion estandar
	@Aggregation(pipeline = {
		"{$group: { _id: '', total: {$stdDevSamp: $favoritos}}}"
	})
	public double stdFav();

	//-------------------------------------------------------------------
	// PARA LOS REETWEETS:

    // Suma 
    @Aggregation(pipeline = {
		"{$group: { _id: '', total: {$sum: $retweets}}}"
	})
	public double sumRet();


	//Desviacion estandar
	@Aggregation(pipeline = {
		"{$group: { _id: '', total: {$stdDevSamp: $retweets}}}"
	})
	public double stdRet();
}
