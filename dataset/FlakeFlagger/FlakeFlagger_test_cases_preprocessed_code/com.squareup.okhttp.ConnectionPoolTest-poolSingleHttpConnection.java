@Test public void poolSingleHttpConnection() throws IOException {
assertNull(connection);
assertEquals(0,pool.getConnectionCount());
assertEquals(1,pool.getConnectionCount());
assertEquals(1,pool.getHttpConnectionCount());
assertEquals(0,pool.getSpdyConnectionCount());
assertEquals(connection,recycledConnection);
assertTrue(recycledConnection.isAlive());
assertNull(recycledConnection);
}