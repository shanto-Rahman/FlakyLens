@Test public void testServerHeartbeat() throws Exception {
Thread.sleep(10000);
Assert.assertTrue(handler.disconnectCount > 0);
}