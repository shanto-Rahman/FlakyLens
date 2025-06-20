@Test public void testHeartbeat() throws Exception {
Thread.sleep(10000);
Assert.assertTrue(handler.disconnectCount == 0);
Assert.assertTrue(handler.connectCount == 1);
}