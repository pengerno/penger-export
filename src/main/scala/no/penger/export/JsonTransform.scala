package no.penger.export

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import com.sksamuel.avro4s._

case class JsonError(message: String)

object JsonTransform {

  private val CHARSET = "UTF-8"

  def jsonToEntity[T](json: String)(implicit s: SchemaFor[T], d: Decoder[T]): Either[JsonError, T] = {
    val in    = new ByteArrayInputStream(json.getBytes(CHARSET))

    val input = AvroInputStream.json[T].from(in).build(AvroSchema[T])
    val entities = input.iterator.toVector
    input.close()

    entities.headOption.toRight(JsonError("No avro fodun"))
  }

  def entityToJson[T](entity: T)(implicit s: SchemaFor[T], d: Encoder[T]): String = {
    val baos   = new ByteArrayOutputStream()

    val os = AvroOutputStream.json[T].to(baos).build(AvroSchema[T])
    os.write(entity)
    os.close()

    val json = baos.toString(CHARSET)
    baos.close()
    json
  }

}
