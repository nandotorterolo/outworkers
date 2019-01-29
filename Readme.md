###  Compile error after upgrade phantom-dsl

> https://github.com/outworkers/phantom/issues/743

```text
[error] /Users/fernandotorterolo/ww/outworkers/src/main/scala/example/Hello.scala:26:80: 

could not find implicit value for parameter helper: com.outworkers.phantom.macros.DatabaseHelper[example.Hello.CassandraDatabase]

[error]   class CassandraDatabase(override val connector: CassandraConnection) extends Database[CassandraDatabase](connector)

``` 

## re-create the issue

To re-create the issue, just bump a mayor version in Dependencies:phantom-dsl >= "2.12.6"

