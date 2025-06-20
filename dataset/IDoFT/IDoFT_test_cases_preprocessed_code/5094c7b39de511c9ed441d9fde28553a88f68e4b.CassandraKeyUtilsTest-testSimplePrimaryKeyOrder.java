@Test public void testSimplePrimaryKeyOrder(){
assertEquals(expected,CassandraKeyUtils.primaryKeyOrder(session,keyspace,table));
}