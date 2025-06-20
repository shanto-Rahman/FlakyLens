@Test public void testCassandraHostSetupSplit(){
assertEquals(3,cassandraHosts.length);
assertEquals(9172,cassandraHosts[2].getPort());
}