import org.scalatest.FunSpec
import yodb.storage.Block

class BlockSuite extends FunSpec {
  describe("hash()") {
    it("should return digest using the parent and data") {
      val actual = Block.genesis.hash.toString
      val expected = "be1bdec0aa74b4dcb079943e70528096cca985f8"
      assert(actual === expected)
    }
  }

  describe("getBytes") {
    it("should concat the bytes with parent") {
      val message = "BANANAS".getBytes()
      val actual = Block(Block.genesis.hash, message).getBytes.length
      val expected = message.length + 20
      assert(actual === expected)
    }
  }

  describe("apply") {
    it("should extract the parent hash") {
      val message = "BANANAS"
      val actual = Block(Block.genesis, message).parent.toString
      val expected = Block.genesis.hash.toString
      assert(actual === expected)
    }

    it("should extract data") {
      val message = "BANANAS"
      val actual = Block(Block.genesis, message).data
      val expected = message.getBytes()
      assert(actual === expected)
    }
  }

  describe("equals()") {
    it("should compare for equality of hashes") {
      val block = Block(Block.genesis, "GRAPES")
      assert(Block(Block.genesis, "APPLE") === Block(Block.genesis, "APPLE"))
      assert(Block(Block.genesis, "APPLE") !== Block(Block.genesis, "APPLE^"))
      assert(Block(Block.genesis, "APPLE") !== Block(block, "APPLE"))
    }
  }

}
