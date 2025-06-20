@Test public void peerHttp2ServerLowersInitialWindowSize() throws Exception {
assertEquals(TYPE_SETTINGS,ackFrame.type);
assertEquals(0,ackFrame.streamId);
assertTrue(ackFrame.ack);
assertEquals(TYPE_SETTINGS,ackFrame.type);
assertEquals(0,ackFrame.streamId);
assertTrue(ackFrame.ack);
assertEquals(3368,connection.peerSettings.getInitialWindowSize());
assertEquals(1684,connection.bytesLeftInWriteWindow);
assertEquals(3368,stream.bytesLeftInWriteWindow);
}