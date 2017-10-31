
import org.scalatest.FunSpec
import yodb.Commit

class CommitTest extends FunSpec {
  private case class WooDoo(a: Int, b: Int)

  describe("constructor()") {
    it("should throw") {
      assertThrows[IllegalArgumentException](Commit("120", Mock.TEST_DATA))
      assertThrows[IllegalArgumentException](Commit(Mock.TEST_DIGEST, 0
        .to(Commit.MAX_DATA_LENGTH + 1)
        .map(_ => "A")
        .mkString)
      )
    }
  }
  describe("toString()") {
    it("should be serializable") {
      val commit = Commit(Mock.TEST_PARENT, Mock.TEST_DATA)
      val actual = Commit.from(commit.toString())
      assert(actual.digest === commit.digest)
    }
  }

  describe("file") {
    it("should skip the first two letters") {
      val commit = Commit(Mock.TEST_PARENT, Mock.TEST_DATA)
      assert(commit.file === Mock.TEST_DIGEST.slice(2, 32))
    }
  }

  describe("dir") {
    it("should pick the first two letters") {
      val commit = Commit(Mock.TEST_PARENT, Mock.TEST_DATA)
      assert(commit.dir === Mock.TEST_DIGEST.slice(0, 2))
    }
  }

  describe("digest") {
    it("should return the md5") {
      val commit = Commit(Mock.TEST_PARENT, Mock.TEST_DATA)
      println(commit.digest)
      assert(commit.digest === Mock.TEST_DIGEST)
    }
  }
}
