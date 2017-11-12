import java.nio.file.{Path, Paths}

import org.scalatest.FunSpec
import yodb.core.Digest
import yodb.io.IOPath

class IOPathTest extends FunSpec {
  private val root: Path = Paths.get("/home/wonderwoman")
  describe("head()") {
    it("should resolve to the complete paths") {
      val actual = IOPath(root).head.toString
      assert(actual === "/home/wonderwoman/.yodb/refs/HEAD")
    }
  }
  describe("objects()") {
    it("should resolve to the complete paths") {
      val actual = IOPath(root).file(Digest("5126af838075857d499b950bc6b46c4b")).toString
      assert(actual === "/home/wonderwoman/.yodb/objects/51/26af838075857d499b950bc6b46c4b")
    }
  }
}
