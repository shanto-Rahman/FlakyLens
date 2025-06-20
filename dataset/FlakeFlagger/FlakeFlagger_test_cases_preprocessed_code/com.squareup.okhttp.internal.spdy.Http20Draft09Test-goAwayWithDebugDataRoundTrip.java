@Test public void goAwayWithDebugDataRoundTrip() throws IOException {
assertEquals(frame,sendGoAway(0,expectedError,expectedData.toByteArray()));
assertEquals(0,lastGoodStreamId);
assertEquals(expectedError,errorCode);
assertEquals(expectedData,debugData);
}