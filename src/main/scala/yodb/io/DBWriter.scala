package yodb.io

import java.io.FileOutputStream
import java.nio.file.Path

import yodb.core.Block


object DBWriter {
  def write(base: Path, commit: Block): String = {
    val digest = commit.digest
    val path = IOPath.objects(base, digest)
    println("HI", path.toString)
    val fd = path.toFile
//    println(fd.getAbsoluteFile)
    fd.mkdirs()
    val file = new FileOutputStream(fd)
    file.write(commit.data)
    digest
  }
}
