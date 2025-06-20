@Test public void testRmiProtocolTimeout() throws Exception {
assertEquals(true,e.isTimeout());
assertEquals(true,e.getMessage().contains("Read timed out"));
}