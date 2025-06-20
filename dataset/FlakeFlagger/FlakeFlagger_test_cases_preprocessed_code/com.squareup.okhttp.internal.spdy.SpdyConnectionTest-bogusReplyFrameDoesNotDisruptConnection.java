@Test public void bogusReplyFrameDoesNotDisruptConnection() throws Exception {
assertEquals(TYPE_RST_STREAM,rstStream.type);
assertEquals(41,rstStream.streamId);
assertEquals(INVALID_STREAM,rstStream.errorCode);
assertEquals(2,ping.payload1);
}