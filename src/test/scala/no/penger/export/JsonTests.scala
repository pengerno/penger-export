package no.penger.export

import org.scalatest.FunSuite

class JsonTests extends FunSuite with TestHelpers {

  test("de-serialize serialize billan") {

    import JsonTransform._

    val billan1 = jsonToEntity[no.penger.export.Billan](resourceToString("/billan-example.json")).right.get
    val json    = entityToJson(billan1)
    val billan2 = jsonToEntity[no.penger.export.Billan](json).right.get

    assert(billan1 === billan2)
  }

}
