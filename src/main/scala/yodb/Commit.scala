package yodb
import java.security.MessageDigest

case class Commit(parent: String, data: String) {
  require(parent.length == 32, "Invalid length of parent digest")
  require(data.length <= 10 * 4 * 1024, "Invalid parent digest")

  private val DIGEST_ALGORITHM = "MD5"
  def digest: String = MessageDigest.getInstance(DIGEST_ALGORITHM)
    .digest(toString.getBytes)
    .map("%02x" format _)
    .mkString
  def dir: String = digest.take(2)
  def file: String = digest.drop(2)
  override def toString: String = parent ++ data.toString
}

object Commit {
  val MAX_DATA_LENGTH: Int = 1024 * 10* 4 // 40kb bytes

  def bytesToHex(bytes: Array[Byte]): String = bytes
    .map("%02x" format _)
    .mkString

  def from(string: String): Commit = {
    val parent = string.slice(0, 32)
    val data = string.slice(32, string.length)
    Commit(parent, data)
  }
}