@Test public void testPing() throws Exception {
connected.set(true);
if (ws == null) {
}
Assert.assertEquals(WebSocketFrameType.PING,ws.getType());
Assert.assertEquals(WebSocketFrameType.PONG,sink.getType());
if (!sink.flush()) {
}
}