@Test public void pingRoundTrip() throws IOException {
assertEquals(frame,sendPingFrame(true,expectedPayload1,expectedPayload2));
assertTrue(ack);
assertEquals(expectedPayload1,payload1);
assertEquals(expectedPayload2,payload2);
}