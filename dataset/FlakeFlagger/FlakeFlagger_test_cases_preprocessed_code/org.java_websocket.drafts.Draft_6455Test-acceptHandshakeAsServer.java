@Test public void acceptHandshakeAsServer() throws Exception {
assertEquals(HandshakeState.MATCHED,draft_6455.acceptHandshakeAsServer(handshakedata));
assertEquals(HandshakeState.NOT_MATCHED,draft_6455.acceptHandshakeAsServer(handshakedataProtocol));
assertEquals(HandshakeState.MATCHED,draft_6455.acceptHandshakeAsServer(handshakedataExtension));
assertEquals(HandshakeState.NOT_MATCHED,draft_6455.acceptHandshakeAsServer(handshakedataProtocolExtension));
assertEquals(HandshakeState.MATCHED,draft_6455.acceptHandshakeAsServer(handshakedata));
assertEquals(HandshakeState.NOT_MATCHED,draft_6455.acceptHandshakeAsServer(handshakedataProtocol));
assertEquals(HandshakeState.MATCHED,draft_6455.acceptHandshakeAsServer(handshakedataExtension));
assertEquals(HandshakeState.NOT_MATCHED,draft_6455.acceptHandshakeAsServer(handshakedataProtocolExtension));
assertEquals(HandshakeState.NOT_MATCHED,draft_6455.acceptHandshakeAsServer(handshakedata));
assertEquals(HandshakeState.MATCHED,draft_6455.acceptHandshakeAsServer(handshakedataProtocol));
assertEquals(HandshakeState.NOT_MATCHED,draft_6455.acceptHandshakeAsServer(handshakedataExtension));
assertEquals(HandshakeState.MATCHED,draft_6455.acceptHandshakeAsServer(handshakedataProtocolExtension));
assertEquals(HandshakeState.MATCHED,draft_6455.acceptHandshakeAsServer(handshakedata));
assertEquals(HandshakeState.MATCHED,draft_6455.acceptHandshakeAsServer(handshakedataProtocol));
assertEquals(HandshakeState.MATCHED,draft_6455.acceptHandshakeAsServer(handshakedataExtension));
assertEquals(HandshakeState.MATCHED,draft_6455.acceptHandshakeAsServer(handshakedataProtocolExtension));
}