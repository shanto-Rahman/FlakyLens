@Test public void readRstStreamFrame() throws IOException {
assertEquals(expectedStreamId,streamId);
assertEquals(ErrorCode.COMPRESSION_ERROR,errorCode);
}