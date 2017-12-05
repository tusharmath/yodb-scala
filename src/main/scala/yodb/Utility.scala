package yodb

object Utility {
  def hex2Bytes(hex: String): Array[Byte] =
    hex
      .replaceAll("[^0-9A-Fa-f]", "")
      .sliding(2, 2)
      .toArray
      .map(Integer.parseInt(_, 16).toByte)

  def bytes2Hex(bytes: Array[Byte]): String =
    bytes
      .map("%02x".format(_))
      .mkString

  def bytes2String(bytes: Array[Byte]): String =
    bytes.map(_.toChar).mkString
}
