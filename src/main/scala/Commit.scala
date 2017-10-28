import java.security.MessageDigest


class Commit(parent: Int, content: String) {

  val DIGEST_ALGORITHM = "MD5"
  override def toString: String = {
    parent.toString + Commit.SEPARATOR + content
  }

  def digest: String = {
    MessageDigest.getInstance(DIGEST_ALGORITHM)
      .digest(toString.getBytes)
      .map("%02x".format(_)).mkString
  }

  def dir: String = {
    digest.slice(0, 2)
  }

  def file: String = {
    digest.slice(2, this.digest.length)
  }
}

object Commit {
  val SEPARATOR = "\n"
  def apply(buffer: String): Commit = {
    val tokens = buffer.split(SEPARATOR)
    val parent = tokens.head.toInt
    val content = tokens.tail.mkString(SEPARATOR)
    new Commit(parent, content)
  }
  def apply[T](parent: Int, content: T): Commit = new Commit(parent, content.toString)
}

