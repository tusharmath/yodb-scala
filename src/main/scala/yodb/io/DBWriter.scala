package yodb.io

import java.io.FileOutputStream
import java.nio.file.Path
import yodb.core.Block


case class DBWriter(base: Path) {
  val dbPath = IOPath(base)
  def write(commit: Block): Unit = {
    createDir(commit)
    createFile(commit)
  }
  private def createFile(commit: Block): Unit =
    new FileOutputStream(dbPath.file(commit.digest).toFile)
      .write(commit.data)

  private def createDir(commit: Block): Boolean =
    dbPath.dir(commit.digest).toFile.mkdirs()

  def prune(): Boolean = {
    val file = dbPath.root.toFile
    file.listFiles().map(_.delete())
    file.delete()
  }
}
