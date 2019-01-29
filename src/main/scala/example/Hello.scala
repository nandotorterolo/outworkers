package example

import com.datastax.driver.core.ProtocolVersion
import com.outworkers.phantom.CassandraTable
import com.outworkers.phantom.connectors.KeySpace
import com.outworkers.phantom.macros.DatabaseHelper._
import com.outworkers.phantom.macros.DatabaseHelper
import com.outworkers.phantom.macros._
import com.outworkers.phantom.dsl._
import com.outworkers.phantom.database.Database
import example.Hello.CassandraDatabase

/**
  * Issue related https://github.com/outworkers/phantom/issues/743
  *
  * To re-create the issue, just bump a mayor version in Dependencies:phantom-dsl >= "2.12.6"
  *
  * /outworkers/src/main/scala/example/Hello.scala:26:80:
  * could not find implicit value for parameter helper: com.outworkers.phantom.macros.DatabaseHelper[example.Hello.CassandraDatabase]
  * [error]   class CassandraDatabase(override val connector: CassandraConnection) extends Database[CassandraDatabase](connector)
  */
object Hello extends App {

  def apply(keySpaceProperty: String = "cassandra.keyspace"): CassandraDatabase = {
    def connector: CassandraConnection = {
      ContactPoints(Seq("hosts"), 1234).withClusterBuilder(builder => {
        builder
          .withProtocolVersion(ProtocolVersion.fromInt(1))
      }).keySpace("keySpace")
    }
    new CassandraDatabase(connector)
  }

  class CassandraDatabase(override val connector: CassandraConnection) extends Database[CassandraDatabase](connector)
}
