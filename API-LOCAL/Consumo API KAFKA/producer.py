from time import sleep
from json import dumps
import tweepy
import json
import time
import config
from kafka import KafkaProducer

producer = KafkaProducer(
    bootstrap_servers=['localhost:9092'],
    value_serializer=lambda x: dumps(x).encode('utf-8')
)


#4 cadenas para la autenticacion
consumer_key = config.API_KEY
consumer_secret = config.API_SECRET_KEY
access_token = config.ACCESS_TOKEN
access_token_secret = config.ACCESS_TOKEN_SECRET
auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_token_secret)
# con este objeto realizaremos todas las llamadas al API
api = tweepy.API(auth,wait_on_rate_limit=True)

j=0
while 1:
    tweets=api.search_tweets(q='#Christmas -has:hashtag', count=10, result_type='popular') 

    print("----------------------------------------------")
    for tweet in tweets:
        tweet=tweet._json
        aux={"counter": j, "text":str(tweet["text"]),"created_at":str(tweet["created_at"]),"retweets":tweet["retweet_count"], "favoritos":tweet["favorite_count"],
        "place":json.dumps(tweet["place"]),"user": tweet["user"]['name']}
        print(aux)
        print(j)
        producer.send('topic_test', value=aux)


    j=j+1
    time.sleep(5.0)
