package no.penger.export

import com.sksamuel.avro4s.{FromRecord, SchemaFor, ToRecord}
import no.penger.export.JsonTransform.{entityToJson, jsonToEntity}
import org.scalatest.FunSuite

class JsonTests extends FunSuite with TestHelpers {

  test("ser-des Billan") {
    assertJson[Billan](resourceToString("/billan-example.json"))
  }

  test("ser-des Boliglan") {
    assertJson[Boliglan](resourceToString("/boliglan-example.json"))
  }

  test("ser-des Utleieforsikring") {
    assertJson[Utleieforsikring](resourceToString("/utleieforsikring-example.json"))
  }

  private def assertJson[T](source: String)(implicit s: SchemaFor[T], f: FromRecord[T], t: ToRecord[T]): Unit = {
    val entity       = jsonToEntity[T](source).right.get
    val json         = entityToJson[T](entity)
    val deSerialized = jsonToEntity[T](json).right.get
    assert(entity == deSerialized)
  }

}
