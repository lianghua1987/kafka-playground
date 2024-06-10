```shell
brew install kafka
brew services start zookeeper
brew services start kafka

# To see logs
kafka-console-consumer --topic hua_kafka_topic --from-beginning --bootstrap-server localhost:9092
```