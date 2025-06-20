@org.junit.Test public void testBinary() throws Exception {
if (getVersion() == WebSocketVersion.V00) {
}
if (ws == null) {
}
Assert.assertEquals(WebSocketFrameType.BINARY,ws.getType());
Assert.assertEquals(WebSocketFrameType.BINARY,sink.getType());
if (!sink.flush()) {
}
}