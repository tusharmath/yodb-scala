import java.nio.file.Paths

import org.scalatest.FunSpec
import yodb.core.Block
import yodb.io.DBWriter

class DBWriterTest extends FunSpec {
  describe("write()") {
    it("should write file to disk") {
      DBWriter.write(Paths.get("/tmp"), Block("ALPHA".getBytes()))
    }
  }
}
