import org.scalatest.FunSpec
import yodb.core.Block

class BlockTest extends FunSpec {
  describe("digest") {
    it("should return the md5 digest of the file") {
      val message = "ALPHA"
      val actual = Block(message.getBytes()).digest.toString
      val expected = "002101f8725e5c78d9f30d87f3fa4c87"
      assert(actual === expected)
    }

    it("should convert string message into block") {
      val message = "ALPHA"
      val actual = Block(message).digest.toString
      val expected = "002101f8725e5c78d9f30d87f3fa4c87"
      assert(actual === expected)
    }
  }
}
