@Test public void testComplexPrimaryKeyOrder(){
assertEquals(expected,CassandraKeyUtils.primaryKeyOrder(session,keyspace,table));
}