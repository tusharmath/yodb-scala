package yodb.core

import java.io.FileOutputStream
import java.nio.file.Paths
import java.security.MessageDigest

import yodb.io.IOPath


case class Block(data: Array[Byte]) {

  private val DIGEST_ALGORITHM = "MD5"
  def digest: String = MessageDigest
    .getInstance(DIGEST_ALGORITHM)
    .digest(data)
    .map("%20x" format _)
    .mkString

  def write(root: String): Unit = new FileOutputStream(
    IOPath.objects(Paths.get(root), digest).toString
  ).write(data)

}
