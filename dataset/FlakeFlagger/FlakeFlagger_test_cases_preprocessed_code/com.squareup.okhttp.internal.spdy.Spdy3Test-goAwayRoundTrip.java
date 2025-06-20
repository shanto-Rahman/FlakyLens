@Test public void goAwayRoundTrip() throws IOException {
assertEquals(frame,sendGoAway(expectedStreamId,expectedError,Util.EMPTY_BYTE_ARRAY));
assertEquals(frame,sendGoAway(expectedStreamId,expectedError,new byte[8]));
assertEquals(expectedStreamId,lastGoodStreamId);
assertEquals(expectedError,errorCode);
assertEquals(0,debugData.size());
}