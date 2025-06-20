@Test public void testSetter() throws URISyntaxException {
assertNull(client.<WebSocketClient>getAttachment());
assertEquals(client.<WebSocketClient>getAttachment(),client);
assertNull(client.<WebSocketClient>getAttachment());
}