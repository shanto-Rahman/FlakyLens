@Test public void testGenerateSchema(){
  String keyspace="mykeyspace";
  String table="mytable";
  String query=CassandraKeyUtils.primarykeyCQL(keyspace,table).toString();
  Map<String,Object> row0=ImmutableMap.of("column_name","col0","kind","partition_key","position",0);
  PrimingRequest primingRequest=PrimingRequest.queryBuilder().withQuery(query).withThen(then().withColumnTypes(column("column_name",TEXT),column("kind",TEXT),column("position",INT)).withRows(row0)).build();
  primingClient.prime(primingRequest);
  Map<String,?> row=ImmutableMap.of("col0","primary key","col1","normal column");
  primingRequest=PrimingRequest.queryBuilder().withQuery("select * from testing").withThen(then().withColumnTypes(column("col0",VARCHAR),column("col1",VARCHAR)).withRows(row)).build();
  primingClient.prime(primingRequest);
  Cluster cluster=Cluster.builder().addContactPoint("localhost").withPort(scassandra.getBinaryPort()).build();
  Session session=cluster.connect();
  CassandraRowMapperFn mapper=new CassandraRowMapperFn(session,ValueProvider.StaticValueProvider.of(keyspace),ValueProvider.StaticValueProvider.of(table));
  ResultSet rs=session.execute("select * from testing");
  Iterator<Row> rows=mapper.map(rs);
  Row next=rows.next();
  Field field=next.getSchema().getField("col0");
  assertEquals("0",field.getType().getMetadataString(CassandraRowMapperFn.KEY_ORDER_METADATA_KEY));
}
