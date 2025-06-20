@Test public void postProcessHandshakeResponseAsServer() throws Exception {
assertTrue(response.hasFieldValue("Date"));
assertTrue(response.hasFieldValue("Sec-WebSocket-Accept"));
assertEquals("Web Socket Protocol Handshake",response.getHttpStatusMessage());
assertEquals("TooTallNate Java-WebSocket",response.getFieldValue("Server"));
assertEquals("upgrade",response.getFieldValue("Connection"));
assertEquals("websocket",response.getFieldValue("Upgrade"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Protocol"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Protocol"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Extensions"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Protocol"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Extensions"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Protocol"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Extensions"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Protocol"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Extensions"));
assertEquals("chat",response.getFieldValue("Sec-WebSocket-Protocol"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Extensions"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Protocol"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Extensions"));
assertEquals("chat",response.getFieldValue("Sec-WebSocket-Protocol"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Extensions"));
assertEquals("test",response.getFieldValue("Sec-WebSocket-Protocol"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Extensions"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Protocol"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Extensions"));
assertEquals("test",response.getFieldValue("Sec-WebSocket-Protocol"));
assertTrue(!response.hasFieldValue("Sec-WebSocket-Extensions"));
}