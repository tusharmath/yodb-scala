package yodb.storage

class Block(val parent: Hash, val data: Array[Byte]) {
  override def equals(obj: scala.Any): Boolean = obj match {
    case block: Block => block.hash == hash
    case _            => false
  }
  def hash: Hash = Hash(getBytes)
  def getBytes: Array[Byte] = parent.getBytes ++ data
}

object Block {
  private val BIT_LENGTH = 20
  private val UTF8 = "UTF8"

  def apply(parent: Hash, data: Array[Byte]): Block = {
    new Block(parent, data)
  }

  def apply(parent: Hash, message: String): Block = {
    new Block(parent, message.getBytes(UTF8))
  }

  def apply(parent: Block, message: String): Block = {
    new Block(parent.hash, message.getBytes(UTF8))
  }

  def apply(block: Array[Byte]): Block = {
    val parent = block.slice(0, BIT_LENGTH)
    new Block(Hash(parent), block.slice(BIT_LENGTH + 1, block.length))
  }

  def genesis: Block = {
    new Block(Hash(new Array[Byte](0)), new Array[Byte](0))
  }
}
