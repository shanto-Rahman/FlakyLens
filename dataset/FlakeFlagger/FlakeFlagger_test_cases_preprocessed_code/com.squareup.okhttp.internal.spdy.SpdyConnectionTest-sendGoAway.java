@Test public void sendGoAway() throws Exception {
assertEquals(1,connection.openStreamCount());
assertEquals(TYPE_HEADERS,synStream1.type);
assertEquals(TYPE_PING,pingFrame.type);
assertEquals(TYPE_GOAWAY,goaway.type);
assertEquals(0,goaway.streamId);
assertEquals(PROTOCOL_ERROR,goaway.errorCode);
}