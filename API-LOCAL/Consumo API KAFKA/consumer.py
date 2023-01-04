from kafka import KafkaConsumer
from json import loads
from time import sleep
import json
import time
import config
import pymongo

consumer = KafkaConsumer(
    'topic_test',
    bootstrap_servers=['localhost:9092'],
    auto_offset_reset='earliest',
    enable_auto_commit=True,
    group_id='my-group-id',
    value_deserializer=lambda x: loads(x.decode('utf-8'))
)

try:
    client=pymongo.MongoClient(config.MONGO_URL,serverSelectionTimeoutMS=config.MONGO_TIME_OUT)
    client.server_info()
    print("conectado")
    coleccionTweets=client[config.MONGO_DB][config.MONGO_COLLECTION]
    for event in consumer:
        event_data = event.value
        # Do whatever you want
        coleccionTweets.insert_one(event_data)
        print(event_data)
        sleep(2.0)
    client.close()
except pymongo.errors.ServerSelectionTimeoutError as errorTiempo:
    print("tiempo exedido:"+errorTiempo)

