@Test public void testHostnameOnlyDefaultPortMultipleHosts(){
assertEquals(CassandraHost.DEFAULT_PORT,cassandraHosts[0].getPort());
assertEquals(CassandraHost.DEFAULT_PORT,cassandraHosts[1].getPort());
assertEquals(1111,cassandraHosts[2].getPort());
}