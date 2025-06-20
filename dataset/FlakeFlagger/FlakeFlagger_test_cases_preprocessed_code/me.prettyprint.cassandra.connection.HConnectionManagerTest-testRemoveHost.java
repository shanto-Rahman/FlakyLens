@Test public void testRemoveHost(){
assertEquals(0,connectionManager.getActivePools().size());
assertTrue(connectionManager.addCassandraHost(cassandraHost));
assertEquals(1,connectionManager.getActivePools().size());
}