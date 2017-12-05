package yodb.storage

import java.security.MessageDigest

import yodb.Utility

class Hash(val getBytes: Array[Byte]) {
  override def toString: String = Utility.bytes2Hex(getBytes)
  override def equals(obj: scala.Any): Boolean = {
    obj match {
      case hash: Hash => hash.getBytes.deep == getBytes.deep
      case _          => false
    }
  }
}

object Hash {
  private val UTF8 = "UTF8"
  private val SHA1 = "SHA-1"
  def apply(content: Array[Byte]): Hash = {
    val md = MessageDigest.getInstance(SHA1)
    new Hash(md.digest(content))
  }

  def apply(content: String): Hash = {
    val md = MessageDigest.getInstance(SHA1)
    new Hash(md.digest(content.getBytes(UTF8)))
  }
}
