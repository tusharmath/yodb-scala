package yodb.storage

import java.io.File
import java.nio.file.{Path, Paths}

import org.rocksdb.{Options, RocksDB}

object Storage {
  // External properties
  val dbLocation: Path = {
    Paths.get(new File("").getAbsolutePath).resolve(".yodb")
  }
  // Internal properties
  private val options = new Options().setCreateIfMissing(true)
  private val db = RocksDB.open(options, dbLocation.toString)
  private val iterator = db.newIterator()
  def get(hash: Hash): Either[Exception, Block] = {
    try {
      val bytes = db.get(hash.getBytes)
      if (bytes != null) Right(bytes).map(data => Block(hash, data))
      else Left(KeyNotFoundException(hash))
    } catch {
      case e: Exception => Left(e)
    }
  }

  // Bootstrapping
  RocksDB.loadLibrary()
  def append(message: Array[Byte]): Either[Exception, Block] = {
    put(Block(last.hash, message))
  }
  def put(block: Block): Either[Exception, Block] = {
    try {
      db.put(block.hash.getBytes, block.data)
      Right(block)
    } catch {
      case e: Exception => Left(e)
    }
  }
  def last: Block = {
    iterator.seekToLast()
    val value = iterator.value()
    if (value != null) Block(value)
    else Block.genesis
  }

  // Internal Types
  case class KeyNotFoundException(key: Hash) extends Exception {}

}
