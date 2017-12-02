package yodb.core

import java.nio.file.{Path, Paths}

import org.fusesource.leveldbjni.JniDBFactory
import org.iq80.leveldb.Options

object Storage {
  implicit val path: Path = Paths.get("~/.yodb")
  private var count = getCount
  private val db = JniDBFactory.factory.open(
    implicitly[Path].toFile,
    new Options().createIfMissing(true)
  )

  private def getCount: Int = {
    var count = 0
    val iterator = db.iterator()
    iterator.seekToFirst()
    try while (iterator.hasNext) {
      count += 1
      iterator.next()
    }
    finally iterator.close()
    count
  }

  def append(value: Array[Byte]): Unit = {
    count += 1
    db.put(Array(count.toByte), value)
  }

  def get(key: Int): Array[Byte] = {
    db.get(Array(key.toByte))
  }

  def close(): Unit = db.close()
}
