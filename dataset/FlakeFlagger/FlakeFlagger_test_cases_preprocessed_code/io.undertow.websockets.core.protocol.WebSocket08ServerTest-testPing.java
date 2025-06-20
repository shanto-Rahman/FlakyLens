@Test public void testPing() throws Exception {
if (ws == null) {
}
Assert.assertEquals(WebSocketFrameType.PING,ws.getType());
Assert.assertEquals(WebSocketFrameType.PONG,sink.getType());
if (!sink.flush()) {
}
}