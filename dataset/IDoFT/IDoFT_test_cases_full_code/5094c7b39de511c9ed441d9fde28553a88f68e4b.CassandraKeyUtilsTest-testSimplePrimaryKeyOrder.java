@Test public void testSimplePrimaryKeyOrder(){
  String keyspace="mykeyspace";
  String table="mytable";
  String query=CassandraKeyUtils.primarykeyCQL(keyspace,table).toString();
  Map<String,Object> row=ImmutableMap.of("column_name","col1","kind","partition_key","position",0);
  PrimingRequest primingRequest=PrimingRequest.queryBuilder().withQuery(query).withThen(then().withColumnTypes(column("column_name",TEXT),column("kind",TEXT),column("position",INT)).withRows(row)).build();
  primingClient.prime(primingRequest);
  Cluster cluster=Cluster.builder().addContactPoint("localhost").withPort(scassandra.getBinaryPort()).build();
  Session session=cluster.connect();
  Map<String,Integer> expected=new HashMap();
  expected.put("col1",0);
  assertEquals(expected,CassandraKeyUtils.primaryKeyOrder(session,keyspace,table));
}
