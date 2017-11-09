import java.nio.file.{Path, Paths}

import org.scalatest.FunSpec
import yodb.io.IOPath

class IOPath extends FunSpec {
  private val root: Path = Paths.get("/home/wonderwoman")
  describe("head()") {
    it("should resolve to the complete paths") {
      val actual = IOPath.head(root).toString
      assert(actual === "/home/wonderwoman/.yodb/refs/HEAD")
    }
  }
  describe("objects()") {
    it("should resolve to the complete paths") {
      val actual = IOPath.objects(root, Mock.TEST_DIGEST).toString
      assert(actual === "/home/wonderwoman/.yodb/objects/51/26af838075857d499b950bc6b46c4b")
    }
  }
}
