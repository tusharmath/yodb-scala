import org.scalatest.FunSpec
import yodb.core.Digest

class DigestTest extends FunSpec {
  describe("toString()") {
    it("should convert ArrayBytes to a string") {
      val expected = "002101f8725e5c78d9f30d87f3fa4c87"
      val actual = Digest(expected).toHexString
      assert(actual === expected)
    }
  }

  it("should inter-convert between various versions") {
    val expected = "002101f8725e5c78d9f30d87f3fa4c87"
    val actual = Digest(Digest(expected).bytes).toHexString
    assert(expected === actual)
  }
}
