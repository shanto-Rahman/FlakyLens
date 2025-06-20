@Test public void testDescribeKeyspace() throws Exception {
ThriftCluster cassandraCluster=new ThriftCluster("Test Cluster",cassandraHostConfigurator,user1Credentials);//RW
assertNotNull(keyspaceDetail);
assertEquals(7,keyspaceDetail.getCfDefs().size());
}