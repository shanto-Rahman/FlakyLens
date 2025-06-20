@Test public void testAddDropKeyspace() throws Exception {
ThriftCluster cassandraCluster=new ThriftCluster("Test Cluster",cassandraHostConfigurator,user1Credentials);//RW
assertNotNull(ksid2);
}