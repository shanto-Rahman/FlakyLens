@Test public void acceptHandshakeAsClient() throws Exception {
assertEquals(HandshakeState.NOT_MATCHED,draft_6455.acceptHandshakeAsClient(request,response));
assertEquals(HandshakeState.NOT_MATCHED,draft_6455.acceptHandshakeAsClient(request,response));
assertEquals(HandshakeState.NOT_MATCHED,draft_6455.acceptHandshakeAsClient(request,response));
assertEquals(HandshakeState.NOT_MATCHED,draft_6455.acceptHandshakeAsClient(request,response));
assertEquals(HandshakeState.MATCHED,draft_6455.acceptHandshakeAsClient(request,response));
assertEquals(HandshakeState.NOT_MATCHED,draft_6455.acceptHandshakeAsClient(request,response));
assertEquals(HandshakeState.MATCHED,draft_6455.acceptHandshakeAsClient(request,response));
assertEquals(HandshakeState.MATCHED,draft_6455.acceptHandshakeAsClient(request,response));
assertEquals(HandshakeState.NOT_MATCHED,draft_6455.acceptHandshakeAsClient(request,response));
assertEquals(HandshakeState.NOT_MATCHED,draft_6455.acceptHandshakeAsClient(request,response));
}