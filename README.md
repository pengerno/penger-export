# Penger Export [![Latest version](https://index.scala-lang.org/pengerno/penger-export/export/latest.svg?color=green)](https://index.scala-lang.org/pengerno/penger-export/export/) [![Build Status](https://travis-ci.org/pengerno/penger-export.svg?branch=master)](https://travis-ci.org/pengerno/penger-export)

## Why?

To provide a versioned and described data format for exchanging data with external entities. Since [Avro](https://avro.apache.org/docs/current/) is used at [FINN](https://www.finn.no) for data exchange, it seems as a good fit for describing our externally delivered data.

## Features

Top level exported types:

* Billån - `src/main/avro/billan.avsc`

Example data for exported formats:

* Billån - `src/main/test/resources/billan-example.json`

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

## TODO:

* Example data for Boliglån
* Bindings: Avro provides bindings for multiple [languages](https://github.com/apache/avro/tree/master/lang). We could therefore aim to provide an integration library for the commonly most used languages at our providers.
