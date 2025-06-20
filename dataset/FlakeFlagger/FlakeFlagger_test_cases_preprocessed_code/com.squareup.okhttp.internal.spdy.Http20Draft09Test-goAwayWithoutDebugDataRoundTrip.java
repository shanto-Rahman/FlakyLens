@Test public void goAwayWithoutDebugDataRoundTrip() throws IOException {
assertEquals(frame,sendGoAway(expectedStreamId,expectedError,Util.EMPTY_BYTE_ARRAY));
assertEquals(expectedStreamId,lastGoodStreamId);
assertEquals(expectedError,errorCode);
assertEquals(0,debugData.size());
}