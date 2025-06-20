@Test public void testShutdown(){
assertEquals(0,clientPool.getNumIdle());
assertEquals(0,clientPool.getNumBlockedThreads());
assertEquals(0,clientPool.getNumActive());
}