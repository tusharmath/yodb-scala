package yodb.io

import java.nio.file.Path

object IOPath {
  def root(base: Path): Path = base.resolve(".yodb")
  def head(base: Path): Path = root(base).resolve("refs").resolve("HEAD")
  def objects(base: Path, digest: String): Path = {
    root(base)
      .resolve("objects")
      .resolve(digest.take(2))
      .resolve(digest.drop(2))
  }
}
