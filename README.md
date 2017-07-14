# penger-impl-export 

## Why?

Because we have to expose data to external providers. When exposing data we have to describe the data in some way. Since [Avro](https://avro.apache.org/docs/current/) is used internally in FINN for data exchange (Kafka), it seems as a good fit for describing our externally delivered data.

## Features

Avro provides bindings for multiple [languages](https://github.com/apache/avro/tree/master/lang). We could therefore aim to provide an integration library for the commonly most used languages at our providers.

## TODO:

* Publishes internally now, publish to maven repository (and remove convenience plugin)
* Add license