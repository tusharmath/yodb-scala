import java.nio.file.Paths

import org.scalatest.{BeforeAndAfterEach, FunSpec}
import yodb.core.Block
import yodb.io.DBWriter

class DBWriterTest extends FunSpec with BeforeAndAfterEach {
  var writer: DBWriter = _

  override def beforeEach: Unit = {
    this.writer = DBWriter(Paths.get("/tmp"))
  }

  override def afterEach = {
    this.writer.prune()
  }

  describe("write()") {
    it("should write file to disk") {
      this.writer.write(Block("ALPHA".getBytes()))
    }
  }
}
