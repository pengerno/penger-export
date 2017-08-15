package no.penger.export

trait TestHelpers {

  private val CHARSET = "UTF-8"

  def resourceToString(path: String): String = {
    val is = scala.io.Source.fromInputStream(getClass.getResourceAsStream(path), CHARSET)
    val text = is.mkString
    is.close()
    text
  }

}
