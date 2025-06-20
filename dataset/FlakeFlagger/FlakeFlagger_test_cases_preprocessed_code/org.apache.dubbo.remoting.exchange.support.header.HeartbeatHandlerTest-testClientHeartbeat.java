@Test public void testClientHeartbeat() throws Exception {
Thread.sleep(10000);
Assert.assertTrue(handler.connectCount > 0);
}