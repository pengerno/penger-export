# Penger Export [![Latest version](https://index.scala-lang.org/pengerno/penger-export/export/latest.svg?color=green)](https://index.scala-lang.org/pengerno/penger-export/export/) [![Build Status](https://travis-ci.org/pengerno/penger-export.svg?branch=master)](https://travis-ci.org/pengerno/penger-export)

## Purpose

To provide a versioned and described data format for exchanging data with external entities. Since [Avro](https://avro.apache.org/docs/current/) is used at [FINN](https://www.finn.no) for data exchange, it seems as a good fit for describing our externally delivered data.

## Features

### Billån

* Schema: [`src/main/avro/billan.avsc`](src/main/avro/billan.avsc)
* Example: [`src/test/resources/billan-example.json`](src/test/resources/billan-example.json)

### Boliglån

* Schema: [`src/main/avro/boliglan.avsc`](src/main/avro/boliglan.avsc)
* Example: [`src/test/resources/boliglan-example.json`](src/test/resources/boliglan-example.json)

### Utleieforsikring

* Schema: [`src/main/avro/utleieforsikring.avsc`](src/main/avro/utleieforsikring.avsc)
* Example: [`src/test/resources/utleieforsikring-example.json`](src/test/resources/utleieforsikring-example.json)

### Forsikringspakke

* Schema: [`src/main/avro/forsikringspakke.avsc`](src/main/avro/forsikringspakke.avsc)
* Example: [`src/test/resources/forsikringspakke-example.json`](src/test/resources/forsikringspakke-example.json)

## Consuming data

For the API integration a multipart POST is issued to the configured endpoint, on the format:

```
POST /some-url
Content-Type: multipart/form-data; boundary=------------------------d74496d66958873e
--------------------------d74496d66958873e
Content-Disposition: form-data; name="body.json"
Content-Type: application/json

{.. json content ..}
--------------------------d74496d66958873e
Content-Disposition: form-data; name="files"; filename="attachment-name.pdf"
Content-Transfer-Encoding: binary

.. data ..
--------------------------d74496d66958873e--
```
If request is successfully consumed, respond with **200 OK**.

## TODO:

* Bindings: Avro provides bindings for multiple [languages](https://github.com/apache/avro/tree/master/lang). We could therefore aim to provide an integration library for the commonly most used languages at our providers.
