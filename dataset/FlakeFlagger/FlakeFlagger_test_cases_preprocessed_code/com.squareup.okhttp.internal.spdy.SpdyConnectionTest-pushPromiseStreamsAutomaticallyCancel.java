@Test public void pushPromiseStreamsAutomaticallyCancel() throws Exception {
assertEquals(TYPE_RST_STREAM,rstStream.type);
assertEquals(2,rstStream.streamId);
assertEquals(CANCEL,rstStream.errorCode);
}