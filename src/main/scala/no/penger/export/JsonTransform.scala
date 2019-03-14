package no.penger.export

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import com.sksamuel.avro4s._

case class JsonError(message: String)

object JsonTransform {

  private val CHARSET = "UTF-8"

  def jsonToEntity[T](json: String)(implicit s: SchemaFor[T], r: FromRecord[T]): Either[JsonError, T] = {
    val in    = new ByteArrayInputStream(json.getBytes(CHARSET))
    val input = AvroInputStream.json[T](in)
    input.close()
    val baktemp = input.singleEntity.toEither.left.map(t => JsonError(t.getMessage))
    baktemp
  }

  def entityToJson[T](entity: T)(implicit s: SchemaFor[T], r: ToRecord[T]): String = {
    val baos   = new ByteArrayOutputStream()
    val output = AvroOutputStream.json[T](baos)
    output.write(entity)
    output.close()
    baos.toString(CHARSET)
  }

}
