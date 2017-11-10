package yodb.core

import yodb.util.Hex

class Digest(val bytes: Array[Byte]) {
  def toHexString: String =  Hex.bytes2hex(bytes)
  override def toString: String = toHexString
}

object Digest {
  def apply(hex: String) = new Digest(Hex.hex2bytes(hex))
  def apply(bytes: Array[Byte]) = new Digest(bytes)
}