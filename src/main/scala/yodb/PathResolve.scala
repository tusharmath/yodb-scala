package yodb

import java.nio.file.Path

object PathResolve {
  def head(root: Path): Path = root.resolve("refs/HEAD")

  def objects(root: Path, commit: Commit): Path = root
    .resolve("objects")
    .resolve(commit.dir)
    .resolve(commit.file)
}
