@Test public void windowUpdateRoundTrip() throws IOException {
assertEquals(frame,windowUpdate(expectedWindowSizeIncrement));
assertEquals(expectedStreamId,streamId);
assertEquals(expectedWindowSizeIncrement,windowSizeIncrement);
}