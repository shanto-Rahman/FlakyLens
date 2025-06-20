@Test public void evictAllConnections(){
assertTrue(connectionCount == 2 || connectionCount == 3);
assertEquals(0,pool.getConnectionCount());
}