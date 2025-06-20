@Test public void testInsertAndGetAndRemoveBadAuth() throws IllegalArgumentException, NoSuchElementException, IllegalStateException, HNotFoundException, Exception {
KeyspaceService keyspace=new KeyspaceServiceImpl("Keyspace1",new QuorumAllConsistencyLevelPolicy(),connectionManager,FailoverPolicy.ON_FAIL_TRY_ALL_AVAILABLE,user1CredentialsBad);//RW
fail("Should have gotten a wrapped AuthenticationException");
assertTrue(he.getCause() instanceof AuthenticationException);
}