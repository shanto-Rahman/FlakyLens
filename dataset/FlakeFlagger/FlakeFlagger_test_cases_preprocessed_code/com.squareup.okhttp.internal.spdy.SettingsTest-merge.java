@Test public void merge(){
assertEquals(100,a.getUploadBandwidth(-1));
assertEquals(PERSIST_VALUE,a.flags(UPLOAD_BANDWIDTH));
assertEquals(400,a.getDownloadBandwidth(-1));
assertEquals(0,a.flags(DOWNLOAD_BANDWIDTH));
assertEquals(500,a.getDownloadRetransRate(-1));
assertEquals(PERSIST_VALUE,a.flags(DOWNLOAD_RETRANS_RATE));
assertEquals(600,a.getMaxConcurrentStreams(-1));
assertEquals(PERSIST_VALUE,a.flags(MAX_CONCURRENT_STREAMS));
}