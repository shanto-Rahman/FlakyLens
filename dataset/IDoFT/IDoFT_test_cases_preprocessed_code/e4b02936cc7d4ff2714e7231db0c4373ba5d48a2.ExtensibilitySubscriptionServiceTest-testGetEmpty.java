@Test public void testGetEmpty() throws InterruptedException {
assertNotNull(result);
assertNotNull(result.documentCount);
assertEquals(0L,(long)result.documentCount);
}