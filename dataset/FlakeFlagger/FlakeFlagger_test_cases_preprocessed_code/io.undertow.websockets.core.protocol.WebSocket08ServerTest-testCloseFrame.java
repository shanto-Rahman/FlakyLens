@Test public void testCloseFrame() throws Exception {
if (getVersion() == WebSocketVersion.V00) {
}
if (ws == null) {
}
Assert.assertEquals(WebSocketFrameType.CLOSE,ws.getType());
latch.countDown();
latch.await();
Assert.assertFalse(receivedResponse.get());
}