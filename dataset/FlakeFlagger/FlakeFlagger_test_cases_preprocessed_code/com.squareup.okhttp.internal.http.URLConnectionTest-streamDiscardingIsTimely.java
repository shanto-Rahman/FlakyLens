@Test public void streamDiscardingIsTimely() throws Exception {
assertTrue(String.format("Time to close: %sms",elapsedMillis),elapsedMillis < 500);
assertEquals(0,server.takeRequest().getSequenceNumber());
assertEquals(0,server.takeRequest().getSequenceNumber());
}