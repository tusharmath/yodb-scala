package yodb.io

import java.nio.file.Path

import yodb.core.Digest

case class IOPath(base: Path) {
  def root: Path = base.resolve(".yodb")
  def refs: Path = root.resolve("refs")
  def head: Path = refs.resolve("HEAD")
  def objects: Path = root.resolve("objects")
  def dir(digest: Digest): Path = objects.resolve(digest.toString take 2)
  def file(digest: Digest): Path = dir(digest).resolve(digest.toString drop 2)
}
