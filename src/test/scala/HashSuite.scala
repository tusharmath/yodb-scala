import org.scalatest.FunSpec
import yodb.storage.Hash

class HashSuite extends FunSpec {
  describe("equals()") {
    it("should compare for content equality") {
      assert(Hash("APPLE") === Hash("APPLE"))
      assert(Hash("APPLE") !== Hash("APPLE^"))
    }
  }
}
