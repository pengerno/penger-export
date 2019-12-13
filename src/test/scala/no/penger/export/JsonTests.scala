package no.penger.export

import com.sksamuel.avro4s.{Decoder, Encoder, FromRecord, SchemaFor}
import no.penger.export.JsonTransform.{entityToJson, jsonToEntity}
import org.scalatest.FunSuite

class JsonTests extends FunSuite with TestHelpers {

  test("ser-des Billan") {
    implicit val sc = Decoder[Billan]
    implicit val a = FromRecord[Billan]
    assertJson[Billan](resourceToString("/billan-example.json"))
  }

  test("ser-des Boliglan") {
    implicit val sc = Decoder[Boliglan]
    implicit val a = FromRecord[Boliglan]
    assertJson[Boliglan](resourceToString("/boliglan-example.json"))
  }

  test("ser-des Utleieforsikring") {
    implicit val sc = Decoder[Utleieforsikring]
    implicit val a = FromRecord[Utleieforsikring]
    assertJson[Utleieforsikring](resourceToString("/utleieforsikring-example.json"))
  }

  test("ser-des Forsikringspakke") {
    implicit val sc = Decoder[Forsikringspakke]
    implicit val a = FromRecord[Forsikringspakke]
    assertJson[Forsikringspakke](resourceToString("/forsikringspakke-example.json"))
  }

  private def assertJson[T](source: String)(implicit s: SchemaFor[T], e: Encoder[T], d: Decoder[T]): Unit = {
    val entity       = jsonToEntity[T](source).right.get
    val json         = entityToJson[T](entity)
    val deSerialized = jsonToEntity[T](json).right.get
    assert(entity == deSerialized)
  }

}
