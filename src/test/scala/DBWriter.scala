import java.nio.file.Paths

import org.scalatest.FunSpec
import yodb.core.Block
import yodb.io.DBWriter

class DBWriter extends FunSpec {
  describe("write()") {
    it("should write file to disk") {
      DBWriter.write(Paths.get(""), Block(Mock.TEST_DATA))
    }
  }
}
