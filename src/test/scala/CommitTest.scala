
import org.scalatest.FunSpec

class CommitTest extends FunSpec {
  private val TEST_DATA = "ALPHA"
  private val TEST_DIGEST = "5126af838075857d499b950bc6b46c4b"
  private val TEST_PARENT = "002101f8721e5c78d9f30d87f3fa4c97"

  private case class WooDoo(a: Int, b: Int)

  describe("constructor()") {
    it("should throw") {
      assertThrows[IllegalArgumentException](Commit("120", TEST_DATA))
      assertThrows[IllegalArgumentException](Commit(TEST_DIGEST, 0
        .to(Commit.MAX_DATA_LENGTH + 1)
        .map(_ => "A")
        .mkString)
      )
    }
  }
  describe("toString()") {
    it("should be serializable") {
      val commit = Commit(TEST_PARENT, TEST_DATA)
      val actual = Commit.from(commit.toString())
      assert(actual.digest === commit.digest)
    }
  }

  describe("file") {
    it("should skip the first two letters") {
      val commit = Commit(TEST_PARENT, TEST_DATA)
      assert(commit.file === TEST_DIGEST.slice(2, 32))
    }
  }

  describe("dir") {
    it("should pick the first two letters") {
      val commit = Commit(TEST_PARENT, TEST_DATA)
      assert(commit.dir === TEST_DIGEST.slice(0, 2))
    }
  }

  describe("digest") {
    it("should return the md5") {
      val commit = Commit(TEST_PARENT, TEST_DATA)
      println(commit.digest)
      assert(commit.digest === TEST_DIGEST)
    }
  }
}
