package yodb.core

import yodb.util.Hex

class Digest(val bytes: Array[Byte]) {
  override def toString: String = Hex.bytes2hex(bytes)
}

object Digest {
  def apply(hex: String) = new Digest(Hex.hex2bytes(hex))
  def apply(bytes: Array[Byte]) = new Digest(bytes)
}
