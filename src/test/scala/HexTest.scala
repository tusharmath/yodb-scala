import org.scalatest.FunSpec
import yodb.util.Hex

class HexTest extends FunSpec {
  it("should inter-convert") {
    val expected = "002101f8725e5c78d9f30d87f3fa4c87"
    val actual = Hex.bytes2hex(Hex.hex2bytes(expected))
    assert(actual === expected)
  }
}
