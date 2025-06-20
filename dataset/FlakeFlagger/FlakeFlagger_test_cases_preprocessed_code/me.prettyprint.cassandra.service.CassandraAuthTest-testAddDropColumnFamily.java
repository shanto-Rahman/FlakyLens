@Test public void testAddDropColumnFamily() throws Exception {
ThriftCluster cassandraCluster=new ThriftCluster("Test Cluster",cassandraHostConfigurator,user1Credentials);//RW
assertNotNull(cfid2);
}