@Test public void testDescribeKeyspacesBadAuth() throws Exception {
ThriftCluster cassandraCluster=new ThriftCluster("Test Cluster",cassandraHostConfigurator,user1CredentialsBad);//RW
fail("Should have gotten a wrapped AuthenticationException");
assertTrue(he.getCause() instanceof AuthenticationException);
}