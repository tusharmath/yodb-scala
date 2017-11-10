package yodb.io

import java.io.FileOutputStream
import java.nio.file.Path

import yodb.core.Block


object DBWriter {

  def write(base: Path, commit: Block): Unit = {
    val dbPath = IOPath(base)
    createDir(commit, dbPath)
    createFile(commit, dbPath)
  }
  private def createFile(commit: Block, dbPath: IOPath): Unit =
    new FileOutputStream(dbPath.file(commit.digest).toFile)
      .write(commit.data)

  private def createDir(commit: Block, dbPath: IOPath): Boolean =
    dbPath.dir(commit.digest).toFile.mkdirs()
}
