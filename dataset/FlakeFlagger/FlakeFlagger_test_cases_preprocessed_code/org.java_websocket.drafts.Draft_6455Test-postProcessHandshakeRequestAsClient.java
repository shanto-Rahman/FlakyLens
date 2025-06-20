@Test public void postProcessHandshakeRequestAsClient() throws Exception {
assertEquals("websocket",request.getFieldValue("Upgrade"));
assertEquals("Upgrade",request.getFieldValue("Connection"));
assertEquals("13",request.getFieldValue("Sec-WebSocket-Version"));
assertTrue(request.hasFieldValue("Sec-WebSocket-Key"));
assertTrue(!request.hasFieldValue("Sec-WebSocket-Extensions"));
assertTrue(!request.hasFieldValue("Sec-WebSocket-Protocol"));
assertTrue(!request.hasFieldValue("Sec-WebSocket-Extensions"));
assertEquals("chat",request.getFieldValue("Sec-WebSocket-Protocol"));
assertTrue(!request.hasFieldValue("Sec-WebSocket-Extensions"));
assertEquals("chat, chat2",request.getFieldValue("Sec-WebSocket-Protocol"));
assertTrue(!request.hasFieldValue("Sec-WebSocket-Extensions"));
assertTrue(!request.hasFieldValue("Sec-WebSocket-Protocol"));
}