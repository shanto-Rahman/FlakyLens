@Test public void testComplexPrimaryKeyOrder(){
  String keyspace="mykeyspace";
  String table="mytable";
  String query=CassandraKeyUtils.primarykeyCQL(keyspace,table).toString();
  Map<String,Object> row0=ImmutableMap.of("column_name","col0","kind","partition_key","position",0);
  Map<String,Object> row1=ImmutableMap.of("column_name","col1","kind","partition_key","position",1);
  Map<String,Object> row2=ImmutableMap.of("column_name","col2","kind","clustering","position",0);
  Map<String,Object> row3=ImmutableMap.of("column_name","col3","kind","clustering","position",1);
  PrimingRequest primingRequest=PrimingRequest.queryBuilder().withQuery(query).withThen(then().withColumnTypes(column("column_name",TEXT),column("kind",TEXT),column("position",INT)).withRows(row0,row1,row2,row3)).build();
  primingClient.prime(primingRequest);
  Cluster cluster=Cluster.builder().addContactPoint("localhost").withPort(scassandra.getBinaryPort()).build();
  Session session=cluster.connect();
  Map<String,Integer> expected=new HashMap();
  expected.put("col0",0);
  expected.put("col1",1);
  expected.put("col2",2);
  expected.put("col3",3);
  assertEquals(expected,CassandraKeyUtils.primaryKeyOrder(session,keyspace,table));
}
