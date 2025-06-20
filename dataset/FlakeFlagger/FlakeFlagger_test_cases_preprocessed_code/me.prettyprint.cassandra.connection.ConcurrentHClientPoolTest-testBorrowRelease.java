@Test public void testBorrowRelease(){
assertEquals(1,clientPool.getNumActive());
assertEquals(0,clientPool.getNumActive());
}