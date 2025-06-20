@Test public void sessionExpired(){
assertSame(expectedSessionId,capturedSession.getValue().getId());
assertSame(manager,capturedSession.getValue().getSessionManager());
}