import java.nio.file.Paths

import org.scalatest.FunSpec
import yodb.{Commit, PathResolve}

class PathResolveTest extends FunSpec {
  describe("head()") {
    it("should resolve to the complete paths") {
      val actual = PathResolve.head(
        Paths.get("/home/wonderwoman/.yodb")
      ).toString
      assert(actual === "/home/wonderwoman/.yodb/refs/HEAD")
    }
  }
  describe("objects()") {
    it("should resolve to the complete paths") {
      val actual = PathResolve.objects(
        Paths.get("/home/wonderwoman/.yodb"),
        Commit(Mock.TEST_DIGEST, "BANANA")
      ).toString
      assert(actual === "/home/wonderwoman/.yodb/objects/92/b73c8d988022e88f47b1a4696d3ae9")
    }
  }
}
