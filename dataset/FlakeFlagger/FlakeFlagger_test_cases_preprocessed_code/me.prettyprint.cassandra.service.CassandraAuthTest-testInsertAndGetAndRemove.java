@Test public void testInsertAndGetAndRemove() throws IllegalArgumentException, NoSuchElementException, IllegalStateException, HNotFoundException, Exception {
KeyspaceService keyspace=new KeyspaceServiceImpl("Keyspace1",new QuorumAllConsistencyLevelPolicy(),connectionManager,FailoverPolicy.ON_FAIL_TRY_ALL_AVAILABLE,user1Credentials);//RW
assertNotNull(col);
assertEquals("testInsertAndGetAndRemove_value_" + i,value);
fail("the value should already being deleted");
}