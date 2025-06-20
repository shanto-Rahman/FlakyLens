@Test public void testHandleRequest_DELETE(){
assertSame(result,delegatingRequestHandler.handleRequest(request));
}