@Test public void getSession(){
assertSame(sessionId,result.getId());
assertSame(manager,result.getSessionManager());
}