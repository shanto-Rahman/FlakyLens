@Test public void peerHttp2ServerZerosCompressionTable() throws Exception {
assertEquals(0,connection.peerSettings.getHeaderTableSize());
assertEquals(0,frameReader.hpackReader.maxHeaderTableByteCount());
}