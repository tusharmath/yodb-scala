package yodb

import java.nio.file.Path

object PathResolve {
  def root(path: Path): Path = path.resolve(".yodb")
  def head(path: Path): Path = root(path).resolve("refs").resolve("HEAD")
  def objects(path: Path, digest: String): Path = root(path)
    .resolve("objects")
    .resolve(digest.take(2))
    .resolve(digest.drop(2))
}
