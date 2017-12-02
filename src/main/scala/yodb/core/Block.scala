package yodb.core

import java.security.MessageDigest


case class Block(data: Array[Byte]) {
  private val DIGEST_ALGORITHM = "MD5"
  def digest: Digest = Digest(MessageDigest
    .getInstance(DIGEST_ALGORITHM)
    .digest(data)
  )
}

object Block {
  def apply(message: String) = new Block(message.getBytes("UTF-8"))
}