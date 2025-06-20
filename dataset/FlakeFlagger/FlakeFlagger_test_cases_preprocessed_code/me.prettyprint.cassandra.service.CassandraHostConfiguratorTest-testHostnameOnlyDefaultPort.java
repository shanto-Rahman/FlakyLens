@Test public void testHostnameOnlyDefaultPort(){
assertEquals(CassandraHost.DEFAULT_PORT,cassandraHosts[0].getPort());
}