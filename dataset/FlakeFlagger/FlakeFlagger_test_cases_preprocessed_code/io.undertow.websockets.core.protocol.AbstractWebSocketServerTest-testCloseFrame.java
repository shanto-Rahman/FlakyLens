@Test public void testCloseFrame() throws Exception {
if (getVersion() == WebSocketVersion.V00) {
}
connected.set(true);
if (ws == null) {
}
Assert.assertEquals(WebSocketFrameType.CLOSE,ws.getType());
latch.countDown();
receivedResponse.set(true);
latch.await();
Assert.assertFalse(receivedResponse.get());
}