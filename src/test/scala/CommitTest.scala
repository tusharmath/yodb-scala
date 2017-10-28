
import org.scalatest.FunSpec

class CommitTest extends FunSpec {
  describe("toString()") {
    it("should be serializable") {
      case class WooDoo(a: Int, b: Int)
      val commit = Commit(120, WooDoo(1, 2))
      val actual = Commit(commit.toString())
      assert(actual.digest === commit.digest)
    }
  }

  describe("file") {
    it("should skip the first two letters") {
      val commit = Commit(100, "ALPHA")
      assert(commit.file === "79d784cb22aa7d5468ab177c1f7dcc")
    }
  }

  describe("dir") {
    it("should pick the first two letters") {
      val commit = Commit(100, "ALPHA")
      assert(commit.dir === "2c")
    }
  }
}
