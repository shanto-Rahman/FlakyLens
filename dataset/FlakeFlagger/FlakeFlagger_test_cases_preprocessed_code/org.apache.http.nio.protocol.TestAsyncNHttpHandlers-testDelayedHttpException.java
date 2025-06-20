/** 
 * This test ensures that HttpExceptions work correctly when they are delayed by a trigger.
 */
@Test public void testDelayedHttpException() throws Exception {
new Thread(){
  @Override public void run(){
    try {
      Thread.sleep(10);
    }
 catch (    InterruptedException ie) {
    }
    trigger.handleException(new HttpException(request.getRequestLine().getUri()));
  }
}
.start();
Thread.sleep(10);
Assert.assertEquals("Test server status",IOReactorStatus.ACTIVE,this.server.getStatus());
if (sessionRequest.getException() != null) {
}
Assert.assertNotNull(sessionRequest.getSession());
Assert.assertEquals("Test client status",IOReactorStatus.ACTIVE,this.client.getStatus());
if (testjob.isSuccessful()) {
Assert.assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR,testjob.getStatusCode());
Assert.assertEquals(testjob.getPattern() + "x" + testjob.getCount(),testjob.getResult());
Assert.fail(testjob.getFailureMessage());
}
}