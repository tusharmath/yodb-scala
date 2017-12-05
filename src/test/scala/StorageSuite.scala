import java.io.File

import org.scalatest.FunSpec
import yodb.Utility
import yodb.storage.{Block, Storage}

class StorageSuite extends FunSpec {
  describe("put()") {
    it("should be able to save and retrieve a block") {
      val message = "APPLE"
      val a0 = Block(Block.genesis, message)
      Storage.put(a0)
      val actual =
        Utility.bytes2String(Storage.get(a0.hash).right.getOrElse(null).data)
      val expected = message
      assert(actual === expected)
    }
  }

  describe("append()") {
    it("should keep appending") {
      val messages = List("APPLE", "BANANAS")
      //      messages
      //        .map(_.getBytes)
      //        .map(Storage.append)
      //        .map(_.right)
      //        .map(_ getOrElse null) match {
      //        case List(blockA, blockB) => {
      //          blockA.parent.digest === Block.genesis.hash
      //        }
      //      }
    }
  }
  def tearDown(env: Int): Unit = {
    new File(Storage.dbLocation.toString).delete()
  }
}
