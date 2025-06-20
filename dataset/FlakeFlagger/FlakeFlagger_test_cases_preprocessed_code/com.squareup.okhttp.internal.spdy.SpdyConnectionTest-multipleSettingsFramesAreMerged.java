@Test public void multipleSettingsFramesAreMerged() throws Exception {
assertEquals(100,connection.peerSettings.getUploadBandwidth(-1));
assertEquals(PERSIST_VALUE,connection.peerSettings.flags(Settings.UPLOAD_BANDWIDTH));
assertEquals(400,connection.peerSettings.getDownloadBandwidth(-1));
assertEquals(0,connection.peerSettings.flags(Settings.DOWNLOAD_BANDWIDTH));
assertEquals(500,connection.peerSettings.getDownloadRetransRate(-1));
assertEquals(PERSIST_VALUE,connection.peerSettings.flags(Settings.DOWNLOAD_RETRANS_RATE));
assertEquals(600,connection.peerSettings.getMaxConcurrentStreams(-1));
assertEquals(PERSIST_VALUE,connection.peerSettings.flags(Settings.MAX_CONCURRENT_STREAMS));
}